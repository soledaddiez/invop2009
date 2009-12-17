package simplex;

public class Variable {
	private String name;
	private double coefficient;
	public Variable(String name, double coefficient){
		this.name = name;
		this.coefficient = coefficient;
	}
	public String name(){
		return name;
	}
	public double getCoefficient(){
		return coefficient;
	}
}
