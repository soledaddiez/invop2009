package gui;

import gui.chart.PlanificacionDeTareasGantt;
import gui.chart.VentanaGrafica;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.sql.Timestamp;
import java.text.Normalizer.Form;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;

import javax.print.attribute.HashAttributeSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import planificacion.Planificador;
import util.HoursConverter;
import modelo.AsignacionProduccion;
import modelo.Cliente;
import modelo.Demanda;
import modelo.Formato;
import modelo.Inventario;
import modelo.Linea;
import modelo.PlanProduccion;
import modelo.Producto;
import com.toedter.calendar.JDateChooser;

import dao.impl.ClienteDAO;
import dao.impl.FormatoDAO;
import dao.impl.InventarioDAO;
import dao.impl.LineaDAO;
import dao.impl.PedidoDAO;
import dao.impl.ProductoDAO;
import excepciones.DataAccessException;

import javax.swing.JPopupMenu;
import java.awt.BorderLayout;

public class MenuPrincipalVisual extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JMenuBar jJMenuBar = null;
	private JMenu jMenu = null;
	private JMenu jMenu1 = null;
	private JMenuItem jMenuItem = null;
	private JDialog jDialog = null;  //  @jve:decl-index=0:visual-constraint="322,10"
	private JPanel jContentPane1 = null;
	private JButton jButton1 = null;
	private JMenuItem jMenuItem2 = null;
	private JDialog jDialog2 = null;  //  @jve:decl-index=0:visual-constraint="869,8"
	private JPanel jContentPane3 = null;
	private JScrollPane jScrollPane = null;
	private JTable jTable = null;
	private JButton jButton3 = null;
	private JScrollPane jScrollPane1 = null;
	private JTable jTable1 = null;
	private JMenuItem jMenuItem1 = null;
	private JDialog jDialog1 = null;  //  @jve:decl-index=0:visual-constraint="1353,15"
	private JPanel jContentPane2 = null;
	private JScrollPane jScrollPane2 = null;
	private JTable jTable2 = null;
	private JLabel jLabel = null;
	private JMenu jMenu2 = null;
	private JDialog jDialog3 = null;  //  @jve:decl-index=0:visual-constraint="-5,276"
	private JPanel jContentPane4 = null;
	private JButton jButton4 = null;
	private JTextArea jTextArea = null;
	private JButton jButton5 = null;
	private JMenuItem jMenuItem3 = null;
	private JDateChooser jDateChooser = null;
	private JDateChooser jDateChooser1 = null;
	private JLabel jLabel1 = null;
	private JPopupMenu jPopupMenu = null;  //  @jve:decl-index=0:visual-constraint="241,435"
	private JMenuItem jMenuItem4 = null;
	private JPopupMenu jPopupMenu1 = null;  //  @jve:decl-index=0:visual-constraint="158,437"
	private JPopupMenu jPopupMenu2 = null;
	private JMenuItem jMenuItem6 = null;
	private JMenuItem jMenuItem7 = null;
	private JMenuItem jMenuItemGuardarUtilidades = null;
	private JScrollPane jScrollPane3 = null;
	private JTable jTableUtilidad = null;
	private JButton jButtonGrafico = null;
	
	private ProductoDAO productoDAO = new ProductoDAO();  //  @jve:decl-index=0:
	private ClienteDAO clienteDAO = new ClienteDAO();  //  @jve:decl-index=0:
	private PedidoDAO pedidoDAO = new PedidoDAO();  //  @jve:decl-index=0:
	private LineaDAO lineasDAO = new LineaDAO();  //  @jve:decl-index=0:
	private InventarioDAO inventarioDAO = new InventarioDAO();  //  @jve:decl-index=0:
	private FormatoDAO formatoDAO = new FormatoDAO();
	
	private Timestamp FechaPlan = new Timestamp(Calendar.getInstance().getTimeInMillis());  //  @jve:decl-index=0:
	
	private List<AsignacionProduccion> asignacion = null;
	private List<Inventario> inventario = null;  //  @jve:decl-index=0:
	private List<Producto> productos = null;  //  @jve:decl-index=0:
	private List<Linea> lineas = null;  //  @jve:decl-index=0:
	
	private int CantidadClientes = 0;
	private int CantidadProductos = 0;
	private JDialog jDialog4 = null;  //  @jve:decl-index=0:visual-constraint="552,462"
	private JPanel jContentPane5 = null;
	private JButton jButton = null;
	private JDialog jDialog5 = null;  //  @jve:decl-index=0:visual-constraint="1355,594"
	private JPanel jContentPaneUtilidad = null;
	private JLabel jLabel2 = null;
	private JMenuItem jMenuItem8 = null;
	private JDialog jDialogUtilidad = null;  //  @jve:decl-index=0:visual-constraint="9,491"
	private JButton jButton6 = null;  //  @jve:decl-index=0:visual-constraint="73,587"
	private JScrollPane jScrollPane4 = null;
	private JLabel jLabel3 = null;
	private JEditorPane jEditorPane1 = null;
	private JEditorPane jEditorPaneAsignaciones = null;

	
	private Image img = new ImageIcon("img/icon.png").getImage();
	private JDialog jDialogFormatosActuales = null;  //  @jve:decl-index=0:visual-constraint="508,786"
	private JPanel jContentPaneFormatosActuales = null;
	private JButton jButton2 = null;
	private JScrollPane jScrollPaneFormatosActuales = null;
	private JTable jTableFormatosActuales = null;
	private JMenuItem jMenuItem5 = null;
	private JMenuItem jMenuItemGuardarFormatosActuales = null;
	private JPopupMenu jPopupMenuFormatosActuales = null;
	private JEditorPane jEditorPaneKeys = null;
	private JScrollPane jScrollPaneKeys = null;
	private JLabel jLabelAyuda = null;
	/**
	 * This is the default constructor
	 */
	public MenuPrincipalVisual() {
		super();
		initialize();
		Muestra M = new Muestra();
		getContentPane().add(M);
		setResizable(false);
		M.start();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(299, 212);
		this.setResizable(false);
		this.setLocation(new Point(300, 200));
		this.setJMenuBar(getJJMenuBar());
		this.setContentPane(getJContentPane());
		this.setTitle("Planificador");
		this.setIconImage(img);
		this.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent e) {
				System.exit(0);
			}
		});
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabel = new JLabel(new ImageIcon("logo.jpg"));
			jLabel.setBounds(new Rectangle(45, 34, 194, 74));
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(jLabel, null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jJMenuBar	
	 * 	
	 * @return javax.swing.JMenuBar	
	 */
	private JMenuBar getJJMenuBar() {
		if (jJMenuBar == null) {
			jJMenuBar = new JMenuBar();
			jJMenuBar.setPreferredSize(new Dimension(20, 20));
			jJMenuBar.add(getJMenu());
			jJMenuBar.add(getJMenu1());
			jJMenuBar.add(getJMenu2());
		}
		return jJMenuBar;
	}

	/**
	 * This method initializes jMenu	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getJMenu() {
		if (jMenu == null) {
			jMenu = new JMenu();
			jMenu.setText("Planificar");
			jMenu.add(getJMenuItem3());
			jMenu.addSeparator();
			jMenu.add(getJMenuItem1());
		}
		return jMenu;
	}

	/**
	 * This method initializes jMenu1	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getJMenu1() {
		if (jMenu1 == null) {
			jMenu1 = new JMenu();
			jMenu1.setText("Configuración");
			jMenu1.add(getJMenuItem2());
			jMenu1.add(getJMenuItem());
			jMenu1.add(getJMenuItem8());
			jMenu1.add(getJMenuItem5());
		}
		return jMenu1;
	}

	/**
	 * This method initializes jMenuItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItem() {
		if (jMenuItem == null) {
			jMenuItem = new JMenuItem();
			jMenuItem.setText("Planilla Pedidos");
			jMenuItem.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mousePressed(java.awt.event.MouseEvent e) {	
					getJDialog().show();
				}
			});
		}
		return jMenuItem;
	}

	/**
	 * This method initializes jDialog	
	 * 	
	 * @return javax.swing.JDialog	
	 */
	private JDialog getJDialog() {
		if (jDialog == null) {
			jDialog = new JDialog(this);
			jDialog.setSize(new Dimension(526, 444));
			jDialog.setTitle("Planilla de Pedidos");
			jDialog.setLocation(new Point(200, 200));
			jDialog.setResizable(false);
			jDialog.setContentPane(getJContentPane1());
			jDialog.setIconImage(img);
			jDialog.addWindowListener(new java.awt.event.WindowAdapter() {
				public void windowClosing(java.awt.event.WindowEvent e) {
					jDialog.show(false);
				}
			});
		}
		return jDialog;
	}

	/**
	 * This method initializes jContentPane1	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJContentPane1() {
		if (jContentPane1 == null) {
			jLabel1 = new JLabel();
			jLabel1.setBounds(new Rectangle(312, 345, 187, 24));
			jLabel1.setText("Elija una fecha:");
			jContentPane1 = new JPanel();
			jContentPane1.setLayout(null);
			jContentPane1.add(getJScrollPane1(), null);
			jContentPane1.add(getJButton1(), null);
			jContentPane1.add(getJButton5(), null);
			jContentPane1.add(getJButton5(), null);
			jContentPane1.add(getJDateChooser(), null);
			jContentPane1.add(jLabel1, null);
			
			jContentPane1.add(new VentanaGrafica(), null);
		}
		return jContentPane1;
	}
	
	private JDateChooser getJDateChooser() {
		if (jDateChooser == null) {
			jDateChooser = new JDateChooser();
			jDateChooser.setBounds(new Rectangle(312, 376, 187, 26));
		}
		return jDateChooser;
	}
	/**
	 * This method initializes jButton1	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton1() {
		if (jButton1 == null) {
			jButton1 = new JButton();
			jButton1.setText("Cerrar Ventana");
			jButton1.setBounds(new Rectangle(164, 360, 125, 31));
			jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					jDialog.show(false);
				}
			});
		}
		return jButton1;
	}

	/**
	 * This method initializes jMenuItem2	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItem2() {
		if (jMenuItem2 == null) {
			jMenuItem2 = new JMenuItem();
			jMenuItem2.setText("Inventario");
			jMenuItem2.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mousePressed(java.awt.event.MouseEvent e) {
					getJDialog2().show();
				}
			});
		}
		return jMenuItem2;
	}

	/**
	 * This method initializes jDialog2	
	 * 	
	 * @return javax.swing.JDialog	
	 */
	private JDialog getJDialog2() {
		if (jDialog2 == null) {
			jDialog2 = new JDialog(this);
			jDialog2.setSize(new Dimension(475, 423));
			jDialog2.setTitle("Planilla Inventario");
			jDialog2.setLocation(new Point(200, 200));
			jDialog2.setResizable(false);
			jDialog2.setContentPane(getJContentPane3());
			jDialog2.setIconImage(img);
			jDialog2.addWindowListener(new java.awt.event.WindowAdapter() {
				public void windowClosing(java.awt.event.WindowEvent e) {
					jDialog2.show(false);
				}
			});
		}
		return jDialog2;
	}

	/**
	 * This method initializes jContentPane3	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJContentPane3() {
		if (jContentPane3 == null) {
			jContentPane3 = new JPanel();
			jContentPane3.setLayout(null);
			jContentPane3.add(getJScrollPane(), null);
			jContentPane3.add(getJButton3(), null);
		}
		return jContentPane3;
	}

	/**
	 * This method initializes jScrollPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setBounds(new Rectangle(4, 5, 453, 340));
			jScrollPane.setViewportView(getJTable());
		}
		return jScrollPane;
	}

	/**
	 * This method initializes jTable	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getJTable() {
		if (jTable == null) {
			jTable = new JTable();
			jTable.setCellSelectionEnabled(true);
			jTable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
			jTable.setShowGrid(true);
			jTable.setComponentPopupMenu(getJPopupMenu());
			DefaultTableModel m=new DefaultTableModel(20,2);
			m.setValueAt("Producto",0,0);
			m.setValueAt("Cantidad",0,1);
			int nroFila=1;
			InventarioDAO inventarioDAO=new InventarioDAO();
			inventario=inventarioDAO.getList();
			for (Inventario inv : inventario){
				m.setValueAt(inv.getProducto().getNombre(),nroFila,0);
				m.setValueAt(inv.getCantidad(),nroFila,1);
				nroFila++;
			}
			jTable.setModel(m);
		}
		return jTable;
	}

	/**
	 * This method initializes jButton3	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton3() {
		if (jButton3 == null) {
			jButton3 = new JButton();
			jButton3.setBounds(new Rectangle(177, 351, 101, 29));
			jButton3.setText("Aceptar");
			jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					jDialog2.show(false);
				}
			});
		}
		return jButton3;
	}

	/**
	 * This method initializes jScrollPane1	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane1() {
		if (jScrollPane1 == null) {
			jScrollPane1 = new JScrollPane();
			jScrollPane1.setBounds(new Rectangle(2, 2, 507, 339));
			jScrollPane1.setViewportView(getJTable1());
		}
		return jScrollPane1;
	}

	/**
	 * This method initializes jTable1	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getJTable1() {
		if (jTable1 == null) {
			jTable1 = new JTable();
			jTable1.setCellSelectionEnabled(true);
			jTable1.setShowGrid(true);
			jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			jTable1.setEnabled(true);
			jTable1.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
			DefaultTableModel m=new DefaultTableModel(20,22);
			m.setValueAt("Producto | Cliente",0,0);
			int nroFila=1;
			
			CantidadProductos= this.getProductos().size();
			for (Producto pro : this.getProductos()){
				m.setValueAt(pro.getNombre(),nroFila,0);
				nroFila++;
			}
			
			List<Cliente> clientes = clienteDAO.getList();
			CantidadClientes = clientes.size();
			for (int i=0; i<clientes.size(); i++){
				m.setValueAt(clientes.get(i).getApellido()+", "+clientes.get(i).getNombre(), 0, i+1);
				for (int j=0; j < this.getProductos().size(); j++)
					m.setValueAt(new Long(0), j+1, i+1);
			}
			jTable1.setModel(m);
		}
		return jTable1;
	}

	/**
	 * This method initializes jMenuItem1	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItem1() {
		if (jMenuItem1 == null) {
			jMenuItem1 = new JMenuItem();
			jMenuItem1.setText("Salir");
			jMenuItem1.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mousePressed(java.awt.event.MouseEvent e) {
					System.exit(0);
				}
			});
		}
		return jMenuItem1;
	}

	/**
	 * This method initializes jDialog1	
	 * 	
	 * @return javax.swing.JDialog	
	 */
	private JDialog getJDialog1() {
		if(jDialog1 == null){
			jDialog1 = new JDialog(getJDialog4());
			jDialog1.setSize(new Dimension(1025, 486));
			jDialog1.setTitle("Asignación de Producción por Línea");
			jDialog1.setLocation(new Point(50, 100));
			jDialog1.setResizable(true);
			jDialog1.setContentPane(getJContentPane2());
			jDialog1.setIconImage(img);
			jDialog1.addWindowListener(new java.awt.event.WindowAdapter() {
				public void windowClosing(java.awt.event.WindowEvent e) {
					jDialog1.show(false);
					jDialog4.show(false);
				}
			});
		}
		return jDialog1;
	}

	//TODO SOLE -> VER DONDE UBICARLO
	private String getDatosResumenProduccion() {

		List<Producto> productos = productoDAO.getList();
		List<Demanda> demandas = pedidoDAO.getDemandasPorFecha(FechaPlan);
		
		String tablaResumen = "<HTML><TABLE BORDER='1'>";
			tablaResumen += "<TR bgcolor='#8FBC8F'>";
			tablaResumen += "<TH colspan='5'>Resumen</TH>";
			tablaResumen += "<TR bgcolor='#8FBC8F'>";
				tablaResumen += "<TH>"+"PRODUCTO"+"</TH>";
				tablaResumen += "<TH>"+"STOCK"+"</TH>";
				tablaResumen += "<TH>"+"DEMANDA"+"</TH>";
				tablaResumen += "<TH>"+"PRODUCIDO"+"</TH>";
				tablaResumen += "<TH>"+"BALANCE"+"</TH>";
			tablaResumen += "</TR>";
			
		for(Producto producto : productos){
			Long produccion = new Long(0);
			for(AsignacionProduccion asign : asignacion){
				if((asign.getOrdenProduccion().getProducto().getId()!= null)&&(asign.getOrdenProduccion().getProducto().getId().equals(producto.getId())))
					produccion +=asign.getOrdenProduccion().getCantidadAProducir();
			}
			Long demanda = new Long(0);
			for(Demanda d : demandas){
				if(d.getProducto().getId().equals(producto.getId())){
					demanda = d.getCantidad();
				}
			}
			
			Long stock = inventarioDAO.getInventarioPorProducto(producto).getCantidad();
			Long balance = stock+produccion-demanda;
			tablaResumen += "<TR>";
				tablaResumen += "<TH>"+producto.getNombre()+"</TH>"; //PRODUCTO
				tablaResumen += "<TH>"+stock.toString()+"</TH>"; //STOCK
				tablaResumen += "<TH>"+demanda.toString()+"</TH>"; //DEMANDA del DIA
				tablaResumen += "<TH>"+produccion.toString()+"</TH>"; //PRODUCIDO
				if(balance >= 0) //BALANCE
					tablaResumen += "<TH><FONT color='green'>"+balance.toString()+"</FONT></TH>"; 
				else
					tablaResumen += "<TH><FONT color='red'>"+balance.toString()+"<></TH>";
			tablaResumen += "</TR>";
			
		}
		
		tablaResumen += "</TABLE></HTML>";
		
		return tablaResumen;
	}
	/**
	 * This method initializes jContentPane2	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJContentPane2() {
		if (jContentPane2 == null) {
			jContentPane2 = new JPanel();
			jContentPane2.setLayout(null);
			jContentPane2.add(getJScrollPane2(), null);
			jContentPane2.add(getJButtonGrafico(), null);
			//jContentPane2.add(getJScrollPane3(), null);
			jContentPane2.add(getJScrollPane4(), null);
		}
		return jContentPane2;
	}

	/**
	 * This method initializes jScrollPane2	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane2() {
		if(jScrollPane2 == null){
			jScrollPane2 = new JScrollPane();
			jScrollPane2.setBounds(new Rectangle(2, 1, 570, 361));
			jScrollPane2.setViewportView(getJEditorPaneAsignaciones());
		}
	
		return jScrollPane2;
	}

	/**
	 * This method initializes jTable2	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getJTable2() {
		if (jTable2 == null) {
			jTable2 = new JTable();
			jTable2.setCellSelectionEnabled(true);
			jTable2.setShowGrid(true);
			jTable2.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			jTable2.setComponentPopupMenu(getJPopupMenu1());
			jTable2.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
			DefaultTableModel m=new DefaultTableModel(20,5);
			List<Linea> lineas=lineasDAO.getList();
			int[] indices=new int[lineas.size()];
			for (int j=0;j<lineas.size();j++){
				m.setValueAt(lineas.get(j).getNombre(),0,j);
				indices[j]=1;
			}
			
			for (AsignacionProduccion a : asignacion) {
				if(a.getOrdenProduccion().getCantidadAProducir() > 0){
					m.setValueAt(a.getOrdenProduccion().getProducto().getNombre() + 
						" x " +a.getOrdenProduccion().getCantidadAProducir()+
						" (" + HoursConverter.getString(a.getOrdenProduccion().getTiempoEstimado()) + " hs)",
						indices[a.getLinea().getId().intValue()-1],
						a.getLinea().getId().intValue()-1);
				}else{
					m.setValueAt(a.getOrdenProduccion().getProducto().getNombre() + 
							" (" + HoursConverter.getString(a.getOrdenProduccion().getTiempoEstimado()) + " hs)",
							indices[a.getLinea().getId().intValue()-1],
							a.getLinea().getId().intValue()-1);
				}
				indices[a.getLinea().getId().intValue()-1] += 1;

			}
			jTable2.setModel(m);
			jTable2.getColumn("A").setPreferredWidth(150);
			jTable2.getColumn("B").setPreferredWidth(150);
			jTable2.getColumn("C").setPreferredWidth(150);
			jTable2.getColumn("D").setPreferredWidth(150);
			jTable2.getColumn("E").setPreferredWidth(150);
		}
		return jTable2;
	}
	
	private String getAsignacionesTable(){
				
		List<Linea> lineas = lineasDAO.getLineas();
		Hashtable<Long, List<AsignacionProduccion>> hashAsignaciones = new Hashtable<Long, List<AsignacionProduccion>>();
		
		String asignacionesText = "<HTML><TABLE border='1'>";
		
		//Encabezados
		asignacionesText += "<TR bgcolor='#8FBC8F'>";
		asignacionesText += "<TH colspan='"+lineas.size()+"'>Asignación por Línea</TH>";
		asignacionesText += "<TR bgcolor='#8FBC8F'>";
			for(Linea linea : lineas){
				hashAsignaciones.put(linea.getId(), new ArrayList<AsignacionProduccion>());
				asignacionesText += "<TH>"+linea.getNombre()+"</TH>";
			}
		asignacionesText += "</TR>";
		
		//Filas
		for (AsignacionProduccion a : asignacion){
			List<AsignacionProduccion> list = hashAsignaciones.get(a.getLinea().getId());
			list.add(list.size(), a);
		}
		
		int max = 0;
		for(Linea linea : lineas){
			max = Math.max(max, hashAsignaciones.get(linea.getId()).size());
		}
		
		for(int i=0; i<max; i++){
			asignacionesText += "<TR>";
			for(Linea linea : lineas){
				List<AsignacionProduccion> list = hashAsignaciones.get(linea.getId());
				asignacionesText += "<TH width='auto'><FONT size='3'>";
				if(list.size()>i){
					AsignacionProduccion a = list.get(i);
					if(a.getOrdenProduccion().getCantidadAProducir() > 0){
						asignacionesText += a.getOrdenProduccion().getProducto().getNombre() + 
						"<br/>x" +a.getOrdenProduccion().getCantidadAProducir()+
						" (" + HoursConverter.getString(a.getOrdenProduccion().getTiempoEstimado()) + " hs)";
					}
					else{
						asignacionesText +="<FONT color = 'gray'><i>"+ a.getOrdenProduccion().getProducto().getNombre() + 
						"<br/>(" + HoursConverter.getString(a.getOrdenProduccion().getTiempoEstimado()) + " hs) </i></FONT>";
					}
				}
				asignacionesText += "</FONT></TH>";
			}
			asignacionesText += "</TR>";
		}
		asignacionesText += "</TABLE></HTML>";
		System.out.println(asignacionesText);
		return asignacionesText;
	}
	
	private JEditorPane getJEditorPaneAsignaciones() {
		if (jEditorPaneAsignaciones == null){
			jEditorPaneAsignaciones = new JEditorPane();
			jEditorPaneAsignaciones.setVisible(true);
			jEditorPaneAsignaciones.setEditable(false);
			jEditorPaneAsignaciones.setContentType("text/html");
			jEditorPaneAsignaciones.setText(getAsignacionesTable());
		}
		return jEditorPaneAsignaciones; //JTable2
	}

	private JButton getJButtonGrafico() {
		if (jButtonGrafico == null) {
			jButtonGrafico = new JButton();
			jButtonGrafico.setBounds(new Rectangle(181, 382, 209, 39));
			jButtonGrafico.setText("Graficar");
			jButtonGrafico.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					getJDialog5().show();
				}
			});
		}
		return jButtonGrafico;
	}

	/**
	 * This method initializes jMenu2	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getJMenu2() {
		if (jMenu2 == null) {
			jMenu2 = new JMenu();
			jMenu2.setText("Acerca de...");
			jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					getJDialog3().show();
				}
			});
		}
		return jMenu2;
	}

	/**
	 * This method initializes jDialog3	
	 * 	
	 * @return javax.swing.JDialog	
	 */
	private JDialog getJDialog3() {
		if (jDialog3 == null) {
			jDialog3 = new JDialog(this);
			jDialog3.setSize(new Dimension(323, 205));
			jDialog3.setTitle("@Copyright");
			jDialog3.setLocation(new Point(300, 200));
			jDialog3.setContentPane(getJContentPane4());
			jDialog3.setIconImage(img);
			jDialog3.addWindowListener(new java.awt.event.WindowAdapter() {
				public void windowClosing(java.awt.event.WindowEvent e) {
					jDialog3.show(false);
				}
			});
		}
		return jDialog3;
	}

	/**
	 * This method initializes jContentPane4	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJContentPane4() {
		if (jContentPane4 == null) {
			jContentPane4 = new JPanel();
			jContentPane4.setLayout(null);
			jContentPane4.add(getJButton4(), null);
			jContentPane4.add(getJTextArea(), null);
		}
		return jContentPane4;
	}

	/**
	 * This method initializes jButton4	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton4() {
		if (jButton4 == null) {
			jButton4 = new JButton();
			jButton4.setBounds(new Rectangle(104, 139, 81, 23));
			jButton4.setText("Aceptar");
			jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					jDialog3.show(false);
				}
			});
		}
		return jButton4;
	}

	/**
	 * This method initializes jTextArea	
	 * 	
	 * @return javax.swing.JTextArea	
	 */
	private JTextArea getJTextArea() {
		if (jTextArea == null) {
			jTextArea = new JTextArea();
			jTextArea.setBounds(new Rectangle(1, 2, 304, 130));
			jTextArea.setEditable(false);
			jTextArea.setBackground(Color.white);
			jTextArea.setText("Programa realizado por:\n\n\tDiez González, Soledad\n\tDurante, Alejandro\n\tGonzález, Rodrigo\n\tSalvatierra,Gonzalo\n\nInvestigación Operativa-Proyecto Final-Diciembre 2009");
		}
		return jTextArea;
	}

	/**
	 * This method initializes jButton5	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton5() {
		if (jButton5 == null) {
			jButton5 = new JButton();
			jButton5.setBounds(new Rectangle(31, 360, 124, 31));
			jButton5.setText("Cargar Planilla");
			jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					Date fecha = jDateChooser.getDate();
					if (fecha!=null){
						List<Cliente> clientes=clienteDAO.getList();
						List<Producto> productos=productoDAO.getList();
						int dia=fecha.getDate();
						int mes=fecha.getMonth();
						int anio=fecha.getYear();
						Date date1=new Date(anio,mes,dia);
						FechaPlan = new Timestamp(date1.getTime());
						/*
						 * Carga de la Planilla de pedidos y
						 * seteo de la fecha de comienzo de planificación
						 */
						for (int contC=0;contC<clientes.size();contC++)
							for (int contP=0;contP<productos.size();contP++)
								jTable1.setValueAt(pedidoDAO.getPedidoTotal(clientes.get(contC),productos.get(contP),FechaPlan),contP+1,contC+1);
					}
				}
			});
		}
		return jButton5;
	}

	/**
	 * This method initializes jMenuItem3	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItem3() {
		if (jMenuItem3 == null) {
			jMenuItem3 = new JMenuItem();
			jMenuItem3.setText("Planificar Produccion...");
			jMenuItem3.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mousePressed(java.awt.event.MouseEvent e) {
					getJDialog4().show();
				}
			});
		}
		return jMenuItem3;
	}

	/**
	 * This method initializes jPopupMenu	
	 * 	
	 * @return javax.swing.JPopupMenu	
	 */
	private JPopupMenu getJPopupMenu() {
		if (jPopupMenu == null) {
			jPopupMenu = new JPopupMenu();
			jPopupMenu.add(getJMenuItem4());
		}
		return jPopupMenu;
	}

	/**
	 * This method initializes jMenuItem4	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItem4() {
		if (jMenuItem4 == null) {
			jMenuItem4 = new JMenuItem();
			jMenuItem4.setText("Guardar Inventario");
			jMenuItem4.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mousePressed(java.awt.event.MouseEvent e) {
					
					TableModel m = jTable.getModel();

					int index = 0;
					for (Inventario inv: inventario){
						String i = m.getValueAt(index+1, 1).toString();
						inv.setCantidad(new Long(i));
						index++;
					}
					InventarioDAO inventarioDAO = new InventarioDAO();
					try {
						inventarioDAO.updateAll(inventario);
					} catch (DataAccessException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
		}
		return jMenuItem4;
	}

	/**
	 * This method initializes jPopupMenu1	
	 * 	
	 * @return javax.swing.JPopupMenu	
	 */
	private JPopupMenu getJPopupMenu1() {
		if (jPopupMenu1 == null) {
			jPopupMenu1 = new JPopupMenu();
//			jPopupMenu1.add(getJMenuItem6());
			jPopupMenu1.addSeparator();
			jPopupMenu1.add(getJMenuItem7());
		}
		return jPopupMenu1;
	}

//	/**
//	 * This method initializes jMenuItem6	
//	 * 	
//	 * @return javax.swing.JMenuItem	
//	 */
//	private JMenuItem getJMenuItem6() {
//		if (jMenuItem6 == null) {
//			jMenuItem6 = new JMenuItem();
//			jMenuItem6.setText("Observar Graficamente");
//			jMenuItem6.addMouseListener(new java.awt.event.MouseAdapter() {
//				public void mousePressed(java.awt.event.MouseEvent e) {
//					getJDialog5().show();
//				}
//			});
//		}
//		return jMenuItem6;
//	}

	/**
	 * This method initializes jMenuItem7	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItem7() {
		if (jMenuItem7 == null) {
			jMenuItem7 = new JMenuItem();
			jMenuItem7.setText("Cerrar");
			jMenuItem7.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mousePressed(java.awt.event.MouseEvent e) {
					jDialog1.show(false);
					jDialog4.show(false);
				}
			});
		}
		return jMenuItem7;
	}

	/**
	 * This method initializes jDialog4	
	 * 	
	 * @return javax.swing.JDialog	
	 */
	private JDialog getJDialog4() {
		if (jDialog4 == null) {
			jDialog4 = new JDialog(this);
			jDialog4.setSize(new Dimension(224, 136));
			jDialog4.setTitle("Planificar Producción");
			jDialog4.setLocation(new Point(300, 200));
			jDialog4.setResizable(false);
			jDialog4.setIconImage(img);
			jDialog4.setContentPane(getJContentPane5());
			jDialog4.addWindowListener(new java.awt.event.WindowAdapter() {
				public void windowClosing(java.awt.event.WindowEvent e) {
					jDialog4.show(false);
				}
			});
		}
		return jDialog4;
	}

	/**
	 * This method initializes jContentPane5	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJContentPane5() {
		if (jContentPane5 == null) {
			jLabel2 = new JLabel();
			jLabel2.setBounds(new Rectangle(2, 8, 215, 22));
			jLabel2.setText("Elija la fecha que desea planificar:");
			jContentPane5 = new JPanel();
			jContentPane5.setLayout(null);
			jContentPane5.add(getJDateChooser1(),null);
			jContentPane5.add(getJButton(), null);
			jContentPane5.add(jLabel2, null);
		}
		return jContentPane5;
	}
	
	private JDateChooser getJDateChooser1() {
		if (jDateChooser1 == null) {
			jDateChooser1 = new JDateChooser();
			jDateChooser1.setBounds(new Rectangle(41, 35, 138, 22));
			Date date = new Date("01/05/2009");
			jDateChooser1.setDate(date);
			
		}
		return jDateChooser1;
	}

	/**
	 * This method initializes jButton	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton() {
		if (jButton == null) {
			jButton = new JButton();
			jButton.setBounds(new Rectangle(63, 74, 90, 24));
			jButton.setText("Planificar");
			jButton.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					Date date1=jDateChooser1.getDate();
					if (date1!=null){
						int dia=date1.getDate();
						int mes=date1.getMonth();
						int anio=date1.getYear();
						Date fecha=new Date(anio,mes,dia);
						FechaPlan=new Timestamp(fecha.getTime());
						/*
						 * Comienzo de la planificación de la producción
						 */
						Long hoy = Calendar.getInstance().getTimeInMillis();
						Timestamp fechaActual = new Timestamp(hoy);
						if(FechaPlan != null)
							fechaActual = FechaPlan;

						List<Demanda> demandas = pedidoDAO.getDemandas(fechaActual);
						
						//TODO Sole PlanProduccion plan = Planificador.planificar(demandas, lineasDAO.getLineas());
						PlanProduccion plan = Planificador.planificar(demandas, lineasDAO.getLineas());
						plan.setFechaInicio(FechaPlan);
						asignacion = plan.getAsignaciones();
						
						getJEditorPaneAsignaciones().setText(getAsignacionesTable());
						getJEditorPane1().setText(getDatosResumenProduccion());
						
						getJDialog1().show();
					}
				}
			});
		}
		return jButton;
	}

	/**
	 * This method initializes jDialog5	
	 * @return javax.swing.JDialog	
	 */
	private JDialog getJDialog5() {
		
			jDialog5 = new JDialog(getJDialog1());
			jDialog5.setSize(new Dimension(800, 600));
			jDialog5.setTitle("Gráfico de Asignación");
			jDialog5.setResizable(true);
			jDialog5.setContentPane(new PlanificacionDeTareasGantt(asignacion));
			jDialog5.addWindowListener(new java.awt.event.WindowAdapter() {
				public void windowClosing(java.awt.event.WindowEvent e) {
					jDialog5.show(false);
				}
			});
			
		return jDialog5;
	}

//Desde aca arranqué con lo de utilidad...
	/**
	 * This method initializes jMenuItem8	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItem8() {
		if (jMenuItem8 == null) {
			jMenuItem8 = new JMenuItem();
			jMenuItem8.setText("Utilidad");
			jMenuItem8.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mousePressed(java.awt.event.MouseEvent e) {
					getJDialogUtilidad().show();
				}
			});
		}
		return jMenuItem8;
	}

	/**
	 * This method initializes jDialogUtilidad	
	 * 	
	 * @return javax.swing.JDialog	
	 */
	private JDialog getJDialogUtilidad() {
		if (jDialogUtilidad == null) {
			jDialogUtilidad = new JDialog(this);
			jDialogUtilidad.setSize(new Dimension(475, 423));
			jDialogUtilidad.setTitle("Utilidades por Producto");
			jDialogUtilidad.setLocation(new Point(200, 200));
			jDialogUtilidad.setResizable(false);
			jDialogUtilidad.setContentPane(getJContentPaneUtilidad());
			jDialogUtilidad.addWindowListener(new java.awt.event.WindowAdapter() {
				public void windowClosing(java.awt.event.WindowEvent e) {
					jDialogUtilidad.show(false);
				}
			});
		}
		return jDialogUtilidad;
	}

	/**
	 * This method initializes jContentPaneUtilidad	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJContentPaneUtilidad() {
		if (jContentPaneUtilidad == null) {
			jContentPaneUtilidad = new JPanel();
			jContentPaneUtilidad.setLayout(null);
			jContentPaneUtilidad.add(getJScrollPane3(), null);
			jContentPaneUtilidad.add(getJButton6(), null);
		}
		return jContentPaneUtilidad;
	}

	/**
	 * This method initializes jButton6	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton6() {
		if (jButton6 == null) {
			jButton6 = new JButton();
			jButton6.setBounds(new Rectangle(177, 351, 101, 29));
			jButton6.setText("Aceptar");
			jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					jDialogUtilidad.show(false);
				}
			});
		}
		return jButton6;
	}
	
	private JScrollPane getJScrollPane3() {
		if (jScrollPane3 == null) {
			jScrollPane3 = new JScrollPane();
			jScrollPane3.setBounds(new Rectangle(4, 5, 453, 340));
			jScrollPane3.setViewportView(getJTableUtilidad());
		}
		return jScrollPane3;
	}
	
	private JTable getJTableUtilidad() {
		if (jTableUtilidad == null) {
			jTableUtilidad = new JTable();
			jTableUtilidad.setCellSelectionEnabled(true);
			jTableUtilidad.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
			jTableUtilidad.setShowGrid(true);
			jTableUtilidad.setComponentPopupMenu(getJPopupMenu2());
			DefaultTableModel m=new DefaultTableModel(20,2);
			m.setValueAt("Producto",0,0);
			m.setValueAt("Utilidad",0,1);
			int nroFila=1;
			
			for (Producto producto : getProductos()){
				m.setValueAt(producto.getNombre(),nroFila,0);
				m.setValueAt(producto.getUtilidad(),nroFila,1);
				nroFila++;
			}
			jTableUtilidad.setModel(m);
		}
		return jTableUtilidad;
	}
	
	/**
	 * This method initializes jPopupMenu	
	 * 	
	 * @return javax.swing.JPopupMenu	
	 */
	private JPopupMenu getJPopupMenu2() {
		if (jPopupMenu2 == null) {
			jPopupMenu2 = new JPopupMenu();
			jPopupMenu2.add(getJMenuItemGuardarUtilidades());
		}
		return jPopupMenu2;
	}

	/**
	 * This method initializes jMenuItemGuardarUtilidades	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItemGuardarUtilidades() {
		if (jMenuItemGuardarUtilidades == null) {
			jMenuItemGuardarUtilidades = new JMenuItem();
			jMenuItemGuardarUtilidades.setText("Guardar Utilidad");
			jMenuItemGuardarUtilidades.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mousePressed(java.awt.event.MouseEvent e) {
					System.out.println("Guardando Utilidades");
					TableModel m = jTableUtilidad.getModel();

					int index = 0;
					for (Producto producto: productos){
						String i = m.getValueAt(index+1, 1).toString();
						producto.setUtilidad(new Double(i));
						index++;
					}
					
					try {
						productoDAO.updateAll(productos);
					} catch (DataAccessException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
		}
		return jMenuItemGuardarUtilidades;
	}

	
	private List<Producto> getProductos(){
		if(this.productos == null)
			productos = productoDAO.getList();
		return productos;
	}

	/**
	 * This method initializes jScrollPane4	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane4() {
		if(jScrollPane4 == null){
			jScrollPane4 = new JScrollPane();
			jScrollPane4.setBounds(new Rectangle(575, 1, 433, 436));
			jScrollPane4.setViewportView(getJEditorPane1());
		}
		return jScrollPane4;
	}

	/**
	 * This method initializes jTextArea1	
	 * 	
	 * @return javax.swing.JTextArea	
	 */
	private JEditorPane getJEditorPane1() {
		if (jEditorPane1 == null){
			jEditorPane1 = new JTextPane();
			jEditorPane1.setVisible(true);
			jEditorPane1.setEditable(false);
			jEditorPane1.setContentType("text/html");
			jEditorPane1.setText(getDatosResumenProduccion());
		}
		return jEditorPane1;
	}

	/**
	 * This method initializes jDialog6	
	 * 	
	 * @return javax.swing.JDialog	
	 */
	private JDialog getJDialogFormatosActuales() {
		if (jDialogFormatosActuales == null) {
			jDialogFormatosActuales = new JDialog(this);
			jDialogFormatosActuales.setSize(new Dimension(428, 331));
			jDialogFormatosActuales.setTitle("Formatos Actuales de las Líneas");
			jDialogFormatosActuales.setContentPane(getJContentPaneFormatosActuales());
			jDialogFormatosActuales.addWindowListener(new java.awt.event.WindowAdapter() {
				public void windowClosing(java.awt.event.WindowEvent e) {
					jDialogFormatosActuales.show(false);
				}
			});
		}
		return jDialogFormatosActuales;
	}

	/**
	 * This method initializes jContentPane6	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJContentPaneFormatosActuales() {
		if (jContentPaneFormatosActuales == null) {
			jLabelAyuda = new JLabel();
			jLabelAyuda.setBounds(new Rectangle(58, 2, 301, 24));
			jLabelAyuda.setText("Ingrese el Id de Formato actual que posee cada linea");
			jContentPaneFormatosActuales = new JPanel();
			jContentPaneFormatosActuales.setLayout(null);
			jContentPaneFormatosActuales.add(getJButton2(), null);
			jContentPaneFormatosActuales.add(getJScrollPaneFormatosActuales(), null);
			jContentPaneFormatosActuales.add(getJScrollPaneKeys(), null);
			jContentPaneFormatosActuales.add(jLabelAyuda, null);
		}
		return jContentPaneFormatosActuales;
	}

	/**
	 * This method initializes jButton2	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton2() {
		if (jButton2 == null) {
			jButton2 = new JButton();
			jButton2.setBounds(new Rectangle(162, 256, 89, 26));
			jButton2.setText("Aceptar");
			jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					getJDialogFormatosActuales().show(false);
				}
			});
		}
		return jButton2;
	}

	/**
	 * This method initializes jScrollPane5	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPaneFormatosActuales() {
		if (jScrollPaneFormatosActuales == null) {
			jScrollPaneFormatosActuales = new JScrollPane();
			jScrollPaneFormatosActuales.setBounds(new Rectangle(3, 32, 407, 101));
			jScrollPaneFormatosActuales.setViewportView(getJTableFormatosActuales());
		}
		return jScrollPaneFormatosActuales;
	}

	/**
	 * This method initializes jTable3	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getJTableFormatosActuales() {
		if (jTableFormatosActuales == null) {
			jTableFormatosActuales = new JTable();
			jTableFormatosActuales.setCellSelectionEnabled(true);
			jTableFormatosActuales.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
			jTableFormatosActuales.setShowGrid(true);
			jTableFormatosActuales.setComponentPopupMenu(getJPopupMenuFormatosActuales());
			lineas = lineasDAO.getLineas();
			DefaultTableModel m=new DefaultTableModel(lineas.size(), 2);
			
			for(int i = 0; i<lineas.size(); i++){
				m.setValueAt(lineas.get(i).getNombre(),i,0);
				m.setValueAt(lineas.get(i).getUltimoFormato().getId(),i,1);
			}
			
			jTableFormatosActuales.setModel(m);
		}
		return jTableFormatosActuales;
	}

	/**
	 * This method initializes jMenuItem5	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItem5() {
		if (jMenuItem5 == null) {
			jMenuItem5 = new JMenuItem();
			jMenuItem5.setText("Formatos Actuales");
			jMenuItem5.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mousePressed(java.awt.event.MouseEvent e) {
					getJDialogFormatosActuales().show();
				}
			});
		}
		return jMenuItem5;
	}
	
	
	/**
	 * This method initializes jPopupMenu	
	 * 	
	 * @return javax.swing.JPopupMenu	
	 */
	private JPopupMenu getJPopupMenuFormatosActuales() {
		if (jPopupMenuFormatosActuales == null) {
			jPopupMenuFormatosActuales = new JPopupMenu();
			jPopupMenuFormatosActuales.add(getJMenuItemGuardarFormatosActuales());
		}
		return jPopupMenuFormatosActuales;
	}
	
	/**
	 * This method initializes jMenuItem4	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItemGuardarFormatosActuales() {
		if (jMenuItemGuardarFormatosActuales == null) {
			jMenuItemGuardarFormatosActuales = new JMenuItem();
			jMenuItemGuardarFormatosActuales.setText("Guardar Formatos");
			jMenuItemGuardarFormatosActuales.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mousePressed(java.awt.event.MouseEvent e) {
					
					TableModel m = jTableFormatosActuales.getModel();

					int index = 0;
					for (Linea linea: lineas){
						String i = m.getValueAt(index, 1).toString();
						Formato f;
						try {
							f = (Formato)formatoDAO.load(new Long(i));
							linea.setUltimoFormato(f);
						} catch (NumberFormatException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (DataAccessException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						index++;
					}
					try {
						lineasDAO.updateAll(lineas);
					} catch (DataAccessException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
		}
		return jMenuItemGuardarFormatosActuales;
	}

	/**
	 * This method initializes jEditorPaneKeys	
	 * 	
	 * @return javax.swing.JEditorPane	
	 */
	private JEditorPane getJEditorPaneKeys() {
		if (jEditorPaneKeys == null) {
			jEditorPaneKeys = new JEditorPane();
			jEditorPaneKeys.setContentType("text/html");
			jEditorPaneKeys.setText(getTextKeys());
		}
		return jEditorPaneKeys;
	}
	
	/**
	 * This method generates a String for Keys of Format...
	 * @return table
	 */
	private String getTextKeys() {
		String table = "<HTML><TABLE border='1'>";
		table += "<TR bgcolor='#8FBC8F'>";
		table += "<TH colspan='"+8+"'>Claves de Formatos</TH>";
		table += "<TR>";
		table += "<TH bgcolor='#8FBC8F'>"+"CLAVE"+"</TH>";
//		table += "</TR>";
		table += "<TH>"+"1"+"</TH>";
		table += "<TH>"+"2"+"</TH>";
		table += "<TH>"+"3"+"</TH>";
		table += "<TH>"+"4"+"</TH>";
		table += "<TH>"+"5"+"</TH>";
		table += "<TH>"+"6"+"</TH>";
		table += "<TH>"+"7"+"</TH>";
		table += "<TR>";
		table += "<TH bgcolor='#8FBC8F'>"+"NOMBRE"+"</TH>";
		table += "<TH>"+"500 cc"+"</TH>";
		table += "<TH>"+"600 cc"+"</TH>";
		table += "<TH>"+"1 lt"+"</TH>";
		table += "<TH>"+"1.5 lts"+"</TH>";
		table += "<TH>"+"2 lts"+"</TH>";
		table += "<TH>"+"2.25 lts"+"</TH>";
		table += "<TH>"+"5 lts"+"</TH>";
		table += "</TABLE></HTML>";
		return table;
	}

	/**
	 * This method initializes jScrollPaneKeys	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPaneKeys() {
		if (jScrollPaneKeys == null) {
			jScrollPaneKeys = new JScrollPane();
			jScrollPaneKeys.setBounds(new Rectangle(16, 143, 382, 103));
			jScrollPaneKeys.setViewportView(getJEditorPaneKeys());
		}
		return jScrollPaneKeys;
	}
	
	
}  //  @jve:decl-index=0:visual-constraint="11,-2"
