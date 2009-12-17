package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import planificacion.Planificador;
import modelo.AsignacionProduccion;
import modelo.Cliente;
import modelo.Demanda;
import modelo.Inventario;
import modelo.Linea;
import modelo.Pedido;
import modelo.PlanProduccion;
import modelo.Producto;

import com.toedter.calendar.JDateChooser;

import dao.impl.ClienteDAO;
import dao.impl.InventarioDAO;
import dao.impl.LineaDAO;
import dao.impl.PedidoDAO;
import dao.impl.ProductoDAO;
import javax.swing.JPopupMenu;
import javax.swing.JScrollBar;

public class MenuPrincipalVisual extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JMenuBar jJMenuBar = null;
	private JMenu jMenu = null;
	private JMenu jMenu1 = null;
	private JMenuItem jMenuItem = null;  //  @jve:decl-index=0:visual-constraint="154,435"
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
	private JDialog jDialog1 = null;  //  @jve:decl-index=0:visual-constraint="1352,9"
	private JPanel jContentPane2 = null;
	private JScrollPane jScrollPane2 = null;
	private JTable jTable2 = null;
	private JButton jButton2 = null;
	private JLabel jLabel = null;
	private JMenu jMenu2 = null;
	private JDialog jDialog3 = null;  //  @jve:decl-index=0:visual-constraint="-12,219"
	private JPanel jContentPane4 = null;
	private JButton jButton4 = null;
	private JTextArea jTextArea = null;
	private JButton jButton5 = null;
	private JMenuItem jMenuItem3 = null;
	private JDateChooser jDateChooser = null;
	private JLabel jLabel1 = null;
	private JPopupMenu jPopupMenu = null;  //  @jve:decl-index=0:visual-constraint="241,435"
	private JMenuItem jMenuItem4 = null;
	private JPopupMenu jPopupMenu1 = null;  //  @jve:decl-index=0:visual-constraint="158,437"
	private JMenuItem jMenuItem5 = null;
	private JMenuItem jMenuItem6 = null;
	private JMenuItem jMenuItem7 = null;
	
	private ProductoDAO productoDAO = new ProductoDAO();  //  @jve:decl-index=0:
	private ClienteDAO clienteDAO = new ClienteDAO();  //  @jve:decl-index=0:
	private PedidoDAO pedidoDAO = new PedidoDAO();  //  @jve:decl-index=0:
	private LineaDAO lineasDAO = new LineaDAO();
	private Timestamp FechaPlan = new Timestamp(Calendar.getInstance().getTimeInMillis());  //  @jve:decl-index=0:
	private List<AsignacionProduccion> asignacion = null;
	private int CantidadClientes = 0;
	private int CantidadProductos = 0;
	/**
	 * This is the default constructor
	 */
	public MenuPrincipalVisual() {
		super();
		initialize();
		Muestra M = new Muestra();
		getContentPane().add(M);
//		pack();
		setResizable(false);
//		setVisible(true);
		M.start();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(300, 204);
		this.setLocation(new Point(300, 200));
		this.setJMenuBar(getJJMenuBar());
		this.setContentPane(getJContentPane());
		this.setTitle("Planificador");
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
			//jLabel.setText("JLabel");
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
			jMenu.add(getJMenuItem());
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
			jMenu1.setText("Cargar");
			jMenu1.add(getJMenuItem2());
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
			jDialog.setContentPane(getJContentPane1());
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
			jDialog2.setContentPane(getJContentPane3());
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
			List<Inventario> inventario=inventarioDAO.getList();
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
			DefaultTableModel m=new DefaultTableModel(20,10);
			m.setValueAt("Producto | Cliente",0,0);
			int nroFila=1;
			List<Producto> productos=productoDAO.getList();
			CantidadProductos=productos.size();
			for (Producto pro : productos){
				m.setValueAt(pro.getNombre(),nroFila,0);
				nroFila++;
			}
			
			List<Cliente> clientes = clienteDAO.getList();
			CantidadClientes = clientes.size();
			for (int i=0; i<clientes.size(); i++){
				m.setValueAt(clientes.get(i).getApellido()+", "+clientes.get(i).getNombre(), 0, i+1);
				for (int j=0;j<productos.size();j++)
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
		if (jDialog1 == null) {
			jDialog1 = new JDialog(this);
			jDialog1.setSize(new Dimension(762, 423));
			jDialog1.setTitle("Asignación de Producción por Línea");
			jDialog1.setLocation(new Point(100, 200));
			jDialog1.setResizable(false);
			jDialog1.setContentPane(getJContentPane2());
			jDialog1.addWindowListener(new java.awt.event.WindowAdapter() {
				public void windowClosing(java.awt.event.WindowEvent e) {
					jDialog1.show(false);
				}
			});
		}
		return jDialog1;
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
			jContentPane2.add(getJButton2(), null);
			//jContentPane2.add(getJScrollPane3(), null);
		}
		return jContentPane2;
	}

	/**
	 * This method initializes jScrollPane2	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane2() {
		if (jScrollPane2 == null) {
			jScrollPane2 = new JScrollPane();
			jScrollPane2.setBounds(new Rectangle(2, 1, 753, 340));
			jScrollPane2.setViewportView(getJTable2());
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
			for (int j=0;j<lineas.size();j++)
				m.setValueAt(lineas.get(j).getNombre(),0,j);
			for (int i=0;i<asignacion.size();i++) {
				AsignacionProduccion a =asignacion.get(i);
				m.setValueAt(a.getOrdenProduccion().getProducto().getNombre() + 
						" x " +a.getOrdenProduccion().getCantidadAProducir()+
						" (" + a.getOrdenProduccion().getTiempoEstimado() + " hs)",
						i+1,a.getLinea().getId().intValue()-1);
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

	/**
	 * This method initializes jButton2	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton2() {
		if (jButton2 == null) {
			jButton2 = new JButton();
			jButton2.setBounds(new Rectangle(332, 360, 91, 27));
			jButton2.setText("Aceptar");
			jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					jDialog1.show(false);
				}
			});
		}
		return jButton2;
	}

	/**
	 * This method initializes jMenu2	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getJMenu2() {
		if (jMenu2 == null) {
			jMenu2 = new JMenu();
			jMenu2.setText("Acerca De...");
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
			jTextArea.setText("Programa realizado por:\n\n\tDiez Gonzalez, Soledad\n\tDurante, Alejandro\n\tGonzalez, Rodrigo\n\tSalvatierra,Gonzalo\n\nInvestigación Operativa-Proyecto Final-Diciembre 2009");
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
//						List<Pedido> pedidos = pedidoDAO.getPedidoPorFecha(FechaPlan);
//						int contProd=1;
//						int contClient=1;
//						for (Pedido p : pedidos){
//							contProd=p.getProducto().getId().intValue();
//							contClient=p.getCliente().getId().intValue();
//							Long sum=(Long)jTable1.getValueAt(contProd,contClient)+p.getCantidad();
//							jTable1.setValueAt(sum,contProd,contClient);
//						}
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
					/*
					 * Comienzo de la planificación de la producción
					 */
					List<Producto> productos =productoDAO.getList();
					/*List<Demanda> demandas=new Vector<Demanda>();
					for (int j=0;j<CantidadClientes;j++)
						for (int i=0;i<CantidadProductos;i++){
							demandas.add(new Demanda(productos.get(i),(Long)jTable1.getValueAt(i+1,j+1),FechaPlan));
							System.out.println("producto: "+productos.get(i).getNombre());
							System.out.println("cantidad: "+(Long)jTable1.getValueAt(i+1,j+1));
							System.out.println("fecha plan: "+FechaPlan);
						}*/
					
					Long now = Calendar.getInstance().getTimeInMillis();
					Timestamp fecha1 = new Timestamp(now);
					Timestamp fecha2 = new Timestamp(now + (1000*60*60*24)*1);
					Timestamp fecha3 = new Timestamp(now + (1000*60*60*24)*2);
					
					List<Demanda> demandas = new Vector<Demanda>();
					demandas.add(new Demanda(productos.get(1), (long) 400, fecha1));
					demandas.add(new Demanda(productos.get(2), (long) 2000, fecha1));
					demandas.add(new Demanda(productos.get(3), (long) 3000, fecha1));
					demandas.add(new Demanda(productos.get(1), (long) 3400, fecha2));
					demandas.add(new Demanda(productos.get(2), (long) 1200, fecha2));
					demandas.add(new Demanda(productos.get(3), (long) 1700, fecha2));
					demandas.add(new Demanda(productos.get(1), (long) 300, fecha3));
					demandas.add(new Demanda(productos.get(2), (long) 2000, fecha3));
					demandas.add(new Demanda(productos.get(3), (long) 3000, fecha3));
					
					PlanProduccion plan = Planificador.planificar(demandas, lineasDAO.getList());
					
					asignacion = plan.getAsignaciones();
					getJDialog1().show();
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
					System.out.println("mousePressed()"); // TODO Auto-generated Event stub mousePressed()
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
			jPopupMenu1.add(getJMenuItem5());
			jPopupMenu1.add(getJMenuItem6());
			jPopupMenu1.addSeparator();
			jPopupMenu1.add(getJMenuItem7());
		}
		return jPopupMenu1;
	}

	/**
	 * This method initializes jMenuItem5	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItem5() {
		if (jMenuItem5 == null) {
			jMenuItem5 = new JMenuItem();
			jMenuItem5.setText("Colorear");
			jMenuItem5.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mousePressed(java.awt.event.MouseEvent e) {
					System.out.println("mousePressed()"); // TODO Auto-generated Event stub mousePressed()
				}
			});
		}
		return jMenuItem5;
	}

	/**
	 * This method initializes jMenuItem6	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItem6() {
		if (jMenuItem6 == null) {
			jMenuItem6 = new JMenuItem();
			jMenuItem6.setText("Observar Graficamente");
			jMenuItem6.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mousePressed(java.awt.event.MouseEvent e) {
					System.out.println("mousePressed()"); // TODO Auto-generated Event stub mousePressed()
				}
			});
		}
		return jMenuItem6;
	}

	/**
	 * This method initializes jMenuItem7	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItem7() {
		if (jMenuItem7 == null) {
			jMenuItem7 = new JMenuItem();
			jMenuItem7.setText("Guardar Estado");
			jMenuItem7.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mousePressed(java.awt.event.MouseEvent e) {
					System.out.println("mousePressed()"); // TODO Auto-generated Event stub mousePressed()
				}
			});
		}
		return jMenuItem7;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
