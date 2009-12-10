package gui;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import java.awt.Dimension;
import javax.swing.JMenu;
import java.awt.Rectangle;
import java.util.List;
import javax.swing.JMenuItem;
import javax.swing.JDialog;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import modelo.Producto;

public class MenuPrincipalVisual extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JMenuBar jJMenuBar = null;
	private JMenu jMenu = null;
	private JMenu jMenu1 = null;
	private JMenuItem jMenuItem = null;
	private JDialog jDialog = null;  //  @jve:decl-index=0:visual-constraint="342,20"
	private JPanel jContentPane1 = null;
	private JButton jButton = null;
	private JButton jButton1 = null;
	private JMenuItem jMenuItem1 = null;
	private JDialog jDialog1 = null;  //  @jve:decl-index=0:visual-constraint="562,40"
	private JPanel jContentPane2 = null;
	private JButton jButton2 = null;
	private JLabel jLabel = null;
	private JTextField jTextField = null;
	private JTextField jTextField1 = null;
	private JMenuItem jMenuItem2 = null;
	private JDialog jDialog2 = null;  //  @jve:decl-index=0:visual-constraint="747,43"
	private JPanel jContentPane3 = null;
	private JScrollPane jScrollPane = null;
	private JTable jTable = null;
	private JButton jButton3 = null;

	/**
	 * This is the default constructor
	 */
	public MenuPrincipalVisual() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(300, 200);
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
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
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
			jMenuItem.setText("Produccion...");
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
			jDialog.setSize(new Dimension(214, 170));
			jDialog.setTitle("Planificar Produccion");
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
			jContentPane1 = new JPanel();
			jContentPane1.setLayout(null);
			jContentPane1.add(getJButton(), null);
			jContentPane1.add(getJButton1(), null);
		}
		return jContentPane1;
	}

	/**
	 * This method initializes jButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton() {
		if (jButton == null) {
			jButton = new JButton();
			jButton.setBounds(new Rectangle(7, 90, 86, 31));
			jButton.setText("Aceptar");
			jButton.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					jDialog.show(false);
				}
			});
		}
		return jButton;
	}

	/**
	 * This method initializes jButton1	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton1() {
		if (jButton1 == null) {
			jButton1 = new JButton();
			jButton1.setBounds(new Rectangle(100, 91, 85, 31));
			jButton1.setText("Cancelar");
			jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					jDialog.show(false);
				}
			});
		}
		return jButton1;
	}

	/**
	 * This method initializes jMenuItem1	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItem1() {
		if (jMenuItem1 == null) {
			jMenuItem1 = new JMenuItem();
			jMenuItem1.setText("Calculos...");
			jMenuItem1.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mousePressed(java.awt.event.MouseEvent e) {
					getJDialog1().show();
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
			jDialog1.setSize(new Dimension(176, 123));
			jDialog1.setTitle("Efectuar Calculos");
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
			jLabel = new JLabel();
			jLabel.setBounds(new Rectangle(16, 14, 38, 16));
			jLabel.setText("QT:");
			jContentPane2 = new JPanel();
			jContentPane2.setLayout(null);
			jContentPane2.add(getJButton2(), null);
			jContentPane2.add(jLabel, null);
			jContentPane2.add(getJTextField(), null);
			jContentPane2.add(getJTextField1(), null);
		}
		return jContentPane2;
	}

	/**
	 * This method initializes jButton2	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton2() {
		if (jButton2 == null) {
			jButton2 = new JButton();
			jButton2.setBounds(new Rectangle(35, 48, 96, 27));
			jButton2.setText("Calcular");
			jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					jDialog1.show(false);
				}
			});
		}
		return jButton2;
	}

	/**
	 * This method initializes jTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField() {
		if (jTextField == null) {
			jTextField = new JTextField();
			jTextField.setBounds(new Rectangle(56, 13, 86, 18));
			jTextField.setText("7");
		}
		return jTextField;
	}

	/**
	 * This method initializes jTextField1	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField1() {
		if (jTextField1 == null) {
			jTextField1 = new JTextField();
			jTextField1.setBounds(new Rectangle(131, 41, 62, 1));
		}
		return jTextField1;
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
			DefaultTableModel m=new DefaultTableModel(20,2);
			try {
			//	ProductoManager p=new ProductoManager();
				m.setValueAt("Producto",0,0);
				m.setValueAt("Cantidad",0,1);
				int nroCol=1;
			//	List<Producto> productos=p.getListadoDeProductos();
			//	for (int i=0;i<productos.size();i++,nroCol++){
			//		m.setValueAt(productos.get(i).getNombre(),nroCol,0);
				}
	//		} 
		catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			m.setValueAt("0",1,1);
			m.setValueAt("0",2,1);
			m.setValueAt("0",3,1);
			m.setValueAt("0",4,1);
			m.setValueAt("0",5,1);
			m.setValueAt("0",6,1);
			m.setValueAt("0",7,1);
			m.setValueAt("0",8,1);
			m.setValueAt("0",9,1);
			m.setValueAt("0",10,1);
			m.setValueAt("0",11,1);
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
			jButton3.setBounds(new Rectangle(182, 353, 89, 22));
			jButton3.setText("Aceptar");
			jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					jDialog2.show(false);
				}
			});
		}
		return jButton3;
	}

}
