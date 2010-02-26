package simplex;

import java.util.LinkedList;
import java.io.PrintStream;

class KpBmax{
	int kp;
	double bmax;
	KpBmax(int kp, double bmax) { this.kp=kp; this.bmax=bmax; }
}

class Constraint
{
    double value;
    LinkedList vars;
    String slack;
    Constraint (double value, LinkedList vars, String slack)
    {
	this.value=value;
	this.vars=vars;
	if (slack!=null) this.slack=slack.intern();
    }
    Constraint (double value, LinkedList vars)
    {
	this.value=value;
	this.vars=vars;
	this.slack=null;
    }
}

public class Simplex
{
    boolean solved;
    String objectivevariable;
    int varindex;
    LinkedList variables;
    LinkedList slackvars;
    LinkedList m1;
    LinkedList m2;
    LinkedList m3;
    Constraint ofun;
    int [] izrov, iposv;
    int N, M, NM1M2;
    double [][]a;
    long startTime;
    long stopTime;

    public Simplex ()
    { 
	solved=false;
	varindex=0;
	ofun=null;
	startTime=0;
	stopTime=0;
	objectivevariable=null;
	variables=new LinkedList();
	slackvars=new LinkedList();
	m1=new LinkedList();
	m2=new LinkedList();
	m3=new LinkedList();
    }
    
    public boolean isSolved(){
    	return solved;
    }
    
    public void addConstraint (String inequality, double value, LinkedList vars, String slack)
    {
	if (slack!=null) {
	    slack=slack.intern();
	    slackvars.add(slack);
	}
	if (inequality.equals("<=")) {      //M1
	    maybeAddVariables(vars);
	    m1.add(new Constraint(value, vars, slack));
	}
	else if (inequality.equals(">=")) { //M2
	    maybeAddVariables(vars);
	    m2.add(new Constraint(value, vars, slack));
	}
	else if (inequality.equals("=")) {  //M3
	    if (slack!=null) System.out.println("Unnecessary slack variable specified in equality constraint - ignored");
	    maybeAddVariables(vars);
	    m3.add(new Constraint(value, vars));
	}
	else System.out.println("Bad inequality in constraint.");
    }
    
    public void addConstraint (String inequality, double value, LinkedList vars)
    {
	maybeAddVariables(vars);
	addConstraint(inequality, value, vars, null);
    }
    
    public void addObjectiveFunction (String name, LinkedList vars)
    {
	objectivevariable=name;
	maybeAddVariables(vars);
	ofun=new Constraint(0.0, vars);
    }
    
    public void describeProblem (PrintStream out)
    {
	if (ofun==null) out.println("WARNING: No Objective Function");
	out.print("Objective Function: ");
	if (ofun!=null) {
	    out.print(objectivevariable);
	    out.print(" = ");
	    printCoefVars(out, ofun.vars, false);
	    out.println("");
	}
	out.println("Constraints:");
	// Print M1
	for (int i=0; i<m1.size(); i++) {
	    Constraint c=(Constraint)m1.get(i);
	    printCoefVars(out, c.vars, false);
	    out.print(" <= ");
	    out.println(c.value);
	}
	// Print M2
	for (int i=0; i<m2.size(); i++) {
	    Constraint c=(Constraint)m2.get(i);
	    printCoefVars(out, c.vars, false);
	    out.print(" >= ");
	    out.println(c.value);
	}
	// Print M3
	for (int i=0; i<m3.size(); i++) {
	    Constraint c=(Constraint)m3.get(i);
	    printCoefVars(out, c.vars, false);
	    out.print(" = ");
	    out.println(c.value);
	}
    }

    public long getSolutionTime ()
    {
	if (solved) return (stopTime-startTime);
	else return -1;
    }
    
    public int solveProblem () throws Exception
    { 
	N=variables.size();
	int M1=m1.size();
	int M2=m2.size();
	int M3=m3.size()+1;
	M=M1+M2+M3;
	int NP=N+1, MP=M+2;
	NM1M2=N+M1+M2;
	a=new double[MP][NP];
	int row=0;
	izrov=new int[N];
	iposv=new int[M];
	// Insert the objective function
	a[row][0]=0;
	for (int ll=0; ll<variables.size(); ll++) {
	    String vname=(String)variables.get(ll);
	    a[row][1+ll]=getVariableCoefficient(ofun.vars, vname);
	}
	row++;
	// Insert M1
	for (int i=0; i<M1; i++) {
	    Constraint c=(Constraint)m1.get(i);
	    a[row][0]=c.value;
	    for (int ll=0; ll<variables.size(); ll++) {
		String vname=(String)variables.get(ll);
		a[row][1+ll]=getVariableCoefficient(c.vars, vname);
		if (a[row][1+ll]!=0.0) a[row][1+ll]=-a[row][1+ll];
	    }
	    row++;
	}
	// Insert M2
	for (int j=0; j<M2; j++) {
	    Constraint c=(Constraint)m2.get(j);
	    a[row][0]=c.value;
	    for (int ll=0; ll<variables.size(); ll++) {
		String vname=(String)variables.get(ll);
		a[row][1+ll]=getVariableCoefficient(c.vars, vname);
		if (a[row][1+ll]!=0.0) a[row][1+ll]=-a[row][1+ll];
	    }
	    row++;
	}
	// Insert M3 (less the object function which was added first).
	for (int k=0; k<M3-1; k++) {
	    Constraint c=(Constraint)m3.get(k);
	    a[row][0]=c.value;
	    for (int ll=0; ll<variables.size(); ll++) {
		String vname=(String)variables.get(ll);
		a[row][1+ll]=getVariableCoefficient(c.vars, vname);
		if (a[row][1+ll]!=0.0) a[row][1+ll]=-a[row][1+ll];
	    }
	    row++;
	}
	startTime=System.currentTimeMillis();
	int result=Simplex.solve(a, MP, NP, M1, M2, M3, izrov, iposv);
	stopTime=System.currentTimeMillis();
	solved=true;
	return result;
    }
    
    public void printFullSolution (PrintStream out)
    { 
	out.print("                    ");
	for (int i=0;i<N;i++)
	    if (izrov[i] < NM1M2) printPostPadded(out, getVarName(izrov[i]), 10);
	out.println("");
	for (int i=0; i<=M; i++) {
	    if (i==0 || iposv[i-1] < NM1M2) {
		if (i>0) printPostPadded(out, getVarName(iposv[i-1]), 5);
		else if (objectivevariable!=null) printPostPadded(out, objectivevariable, 5);
                else out.print("     ");
		printDouble(out, a[i][0]);
		for (int j=1; j<=N; j++)
		    if (izrov[j-1] < NM1M2) 
			printDouble(out, a[i][j]);
		out.println("");
	    }
	}
    }
    
    public void printSolution (PrintStream out)
    { 
	if (objectivevariable!=null) {
	    printPostPadded(out, objectivevariable, 5);
	    out.print(" = ");
	    printDouble(out, getSolutionValue(objectivevariable));
	    out.println("");
	}
	for (int i=0; i<variables.size(); i++) {
	    String vn=(String)variables.get(i);
	    printPostPadded(out, vn, 5);
	    out.print(" = ");
	    printDouble(out, getSolutionValue(vn));
	    out.println("");
	}
    }
    
    public double getSolutionValue (String varname)
    {
	if (solved) {
	    for (int i=0; i<=M; i++) {
		if (i==0 || iposv[i-1] < NM1M2) {
		    if (i>0) { 
			if (getVarName(iposv[i-1]).equals(varname)) return a[i][0]; 
		    }
		    else {
			if (objectivevariable!=null) {
			    if (objectivevariable.equals(varname)) return a[i][0]; 
			}
		    }
		}
	    }
	    return 0.0;
	}
	return 0; // Maybe we should complain rather than return a silly value?
    }
    
    public static int solve (double [][] a, int nrows, int ncols, int m1, int m2, int m3, int [] izrov, int [] iposv) throws Exception
    {
	double EPS=1.0e-14;
	int i, k, ip, is, kh, nl1;
	double q1;
	KpBmax res=new KpBmax(0, 0.0);
	
	int m=nrows-2;
	int n=ncols-1;
	if (m != (m1+m2+m3)) {
	    System.out.println("Bad input constraint counts in Simplex");
	    throw new SimplexException("Bad input constraint counts in Simplex");
	}
	int [] l1=new int[n+1], l3=new int [m];
	nl1=n;
	for (k=0; k<n; k++) {
	    l1[k]=k+1;
	    izrov[k]=k;
	}
	for (i=1; i<=m; i++) {
	    if (a[i][0] < 0.0) {
		System.out.println("Bad input tableau in Simplex");
		throw new SimplexException("Bad input tableau in Simplex");
	    }
	    iposv[i-1]=n+i-1;
	}
	if (m2+m3 != 0) {
	    for (i=0; i<m2; i++) l3[i]=1;
	    for (k=0; k<(n+1); k++) {
		q1=0.0;
		for (i=m1+1; i<m+1; i++) q1 += a[i][k];
		a[m+1][k] = -q1;
	    }
	    for (;;) {
	    one:    {
		simp1(a, m+1, l1, nl1, 0, res);
		if (res.bmax <= EPS && a[m+1][0] < -EPS) {
		    return -1;
		}
		else if (res.bmax <= EPS && a[m+1][0] <= EPS) {
		    for (ip=m1+m2+1; ip<m+1; ip++) {
			if (iposv[ip-1] == (ip+n-1)) {
			    simp1(a, ip, l1, nl1, 1, res);
			    if (res.bmax > EPS) break one;
			}
		    }
		    for (i=m1+1; i<=m1+m2; i++)
			if (l3[i-m1-1] == 1)
			    for (k=0; k<n+1; k++)
				a[i][k]= -a[i][k];
		    break;
		}
		ip=simp2(a, m, n, res.kp);
		if (ip == 0) {
		    return -1;
		}
	    }
	    simp3(a, m+1, n, ip, res.kp);
	    if (iposv[ip-1] >= (n+m1+m2)) {
		for (k=0; k<nl1; k++)
		    if (l1[k]==res.kp) break;
		--nl1;
		for (is=k; is<nl1; is++) l1[is]=l1[is+1];
	    } else {
		kh=iposv[ip-1]-m1-n+1;
		if (kh >= 1 && l3[kh-1] != 0) {
		    l3[kh-1]=0;
		    ++a[m+1][res.kp];
		    for (i=0; i<m+2; i++)
			a[i][res.kp]= -a[i][res.kp];
		}
	    }
	    { int tmp; tmp=izrov[res.kp-1]; izrov[res.kp-1]=iposv[ip-1]; iposv[ip-1]=tmp; } // Swap
	    }
	}
	for (;;) {
	    simp1(a, 0, l1, nl1, 0, res);
	    if (res.bmax <= EPS) {
		return 0;
	    }
	    ip=simp2(a, m, n, res.kp);
	    if (ip == 0) {
		return 1;
	    }
	    simp3(a, m, n, ip, res.kp);
	    { int tmp; tmp=izrov[res.kp-1]; izrov[res.kp-1]=iposv[ip-1]; iposv[ip-1]=tmp; } // Swap
	}
    }
    
    static void simp1 (double [][] a, int mm, int [] ll, int nll, int iabf, KpBmax res)
    {
	int k;
	double test;
	
	if (nll <= 0)	res.bmax=0.0;
	else {
	    res.kp=ll[0];
	    res.bmax=a[mm][res.kp];
	    for (k=1; k<nll; k++) {
		if (iabf == 0) test=a[mm][ll[k]]-res.bmax;
		else test=Math.abs(a[mm][ll[k]])-Math.abs(res.bmax);
		if (test > 0.0) {
		    res.bmax=a[mm][ll[k]];
		    res.kp=ll[k];
		}
	    }
	}
    }
    
    static int simp2 (double [][] a, int m, int n, int kp)
    {
	double EPS=1.0e-14;
	int k, i, ip=0;
	double qp=0.0, q0=0.0, q, q1;
	
	for (i=0; i<m; i++)
	    if (a[i+1][kp] < -EPS) break;
	
	if (i+1>m) return ip;
	q1 = -a[i+1][0]/a[i+1][kp];
	ip=i+1;
	for (i=ip; i<m; i++) {
	    if (a[i+1][kp] < -EPS) {
		q = -a[i+1][0]/a[i+1][kp];
		if (q < q1) {
		    ip=i+1;
		    q1=q;
		} else if (q == q1) {
		    for (k=0; k<n; k++) {
			qp = -a[ip][k+1]/a[ip][kp];
			q0 = -a[i][k+1]/a[i][kp];
			if (q0 != qp) break;
		    }
		    if (q0 < qp) ip=i+1;
		}
	    }
	}
	return ip;
    }
    
    static void simp3 (double [][] a, int i1, int k1, int ip, int kp)
    {
	int ii, kk;
	double piv;
	
	piv=1.0/a[ip][kp];
	for (ii=0; ii<i1+1; ii++)
	    if (ii != ip) {
		a[ii][kp] *= piv;
		for (kk=0; kk<k1+1; kk++)
		    if (kk != kp)
			a[ii][kk] -= a[ip][kk]*a[ii][kp];
	    }
	for (kk=0; kk<k1+1; kk++)
	    if (kk != kp) a[ip][kk] *= -piv;
	a[ip][kp]=piv;
    }
    
    void printDouble (PrintStream out, double val)
    {
	if (val>0) val=Math.round(100000.0*(val+0.00001))/100000.0;
        else if (val<0) val=Math.round(100000.0*(val-0.00001))/100000.0;
	String rep=Double.toString(val).trim();
        if (rep.length()>10) rep=rep.substring(0, 10);
	int dotpos=rep.indexOf(".");
        int replen=rep.length();
	String prepad= "     "; // 5 spaces
		if(dotpos < prepad.length() && dotpos >= 0){
			String nurep=prepad.substring(dotpos).concat(rep);
		    printPostPadded(out, nurep, 10);
		}
    }
    
    void printPostPadded (PrintStream out, String rep, int fieldsize)
    {   
	String pad="                    "; // 20 spaces
	if (rep.length()>fieldsize) rep=rep.substring(0, fieldsize);
        else rep=rep.concat(pad.substring(rep.length(), fieldsize));
        System.out.print(rep);
    }
    
    void maybeAddVariables (LinkedList vars)
    {
	for (int i=0; i<vars.size(); i++) {
	    Variable avar=(Variable)vars.get(i);
	    String vname=avar.name();
	    if (!variables.contains(vname)) variables.add(vname);
	}
    }
    
    double getVariableCoefficient (LinkedList vars, String name){
		for (int pos=0; pos<vars.size(); pos++) {
		    Variable v = (Variable) vars.get(pos);
		    if (v.name().equals(name)) return v.getCoefficient();
		}
		return 0.0;
    }
    
    String getVarName (int index)
    {
	int vs=variables.size();
	if (index<vs) return (String)variables.get(index);
	if (index-vs<slackvars.size()) return (String)slackvars.get(index-vs);
	else return "?";
    }
    
    void printCoefVars (PrintStream out, LinkedList vars, boolean leadingsign)
    {
	for (int i=0; i<vars.size(); i++) {
	    Variable var=(Variable)vars.get(i);
	    double coef = var.getCoefficient();
	    if (coef!=0) {
		if ((coef>0)&&leadingsign) out.print("+");
		if (coef==-1) out.print("-");
		else if (coef!=1) out.print(coef);
		out.print(var.name());
	    }
	    leadingsign=true;
	}
    }
}

