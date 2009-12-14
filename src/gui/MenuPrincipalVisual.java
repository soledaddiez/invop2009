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

import dao.impl.ProductoDAO;
import java.awt.BorderLayout;

//import modelo.Producto;

public class MenuPrincipalVisual extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JMenuBar jJMenuBar = null;
	private JMenu jMenu = null;
	private JMenu jMenu1 = null;
	private JMenuItem jMenuItem = null;
	private JDialog jDialog = null;  //  @jve:decl-index=0:visual-constraint="322,10"
	private JPanel jContentPane1 = null;
	private JButton jButton = null;
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
			jDialog.setSize(new Dimension(527, 421));
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
			jContentPane1.add(getJScrollPane1(), null);
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
			jButton.setBounds(new Rectangle(155, 345, 91, 31));
			jButton.setText("Planificar");
			jButton.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					getJDialog1().show();
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
			jButton1.setText("Cancelar");
			jButton1.setBounds(new Rectangle(263, 346, 85, 30));
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
//				ProductoDAO p=new ProductoDAO();
				m.setValueAt("Producto",0,0);
				m.setValueAt("Cantidad",0,1);
//				int nroCol=1;
//				List<Producto> productos=p.getList();
//				for (Producto pro : productos){
//					m.setValueAt(pro.getNombre(),nroCol,0);
//					nroCol++;
//				}
			} 
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
			jTable1.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
			DefaultTableModel m=new DefaultTableModel(20,10);
			m.setValueAt("Cliente1",0,1);
			m.setValueAt("Cliente2",0,2);
			m.setValueAt("Cliente3",0,3);
			m.setValueAt("Cliente4",0,4);
			m.setValueAt("Cliente5",0,5);
			m.setValueAt("Cliente6",0,6);
			m.setValueAt("Cliente7",0,7);
			m.setValueAt("Cliente8",0,8);
			m.setValueAt("Stock 6 am",0,9);
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
			jDialog1 = new JDialog(getJDialog());
			jDialog1.setSize(new Dimension(472, 423));
			jDialog1.setContentPane(getJContentPane2());
			jDialog1.addWindowListener(new java.awt.event.WindowAdapter() {
				public void windowClosing(java.awt.event.WindowEvent e) {
					jDialog1.show(false);
					jDialog.show(false);
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
			jScrollPane2.setBounds(new Rectangle(2, 1, 450, 343));
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
			jTable2.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
			DefaultTableModel m=new DefaultTableModel(20,6);
			m.setValueAt("Linea1",0,1);
			m.setValueAt("Linea2",0,2);
			m.setValueAt("Linea3",0,3);
			m.setValueAt("Linea4",0,4);
			m.setValueAt("Linea5",0,5);
			jTable2.setModel(m);
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
			jButton2.setBounds(new Rectangle(168, 350, 91, 27));
			jButton2.setText("Aceptar");
			jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					jDialog1.show(false);
					jDialog.show(false);
				}
			});
		}
		return jButton2;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
