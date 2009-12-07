package gui;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import modelo.Producto;
import dbConnector.ProductoManager;


public class PedidosPanel extends JPanel{
	private Vector<Producto> productos;
	
	public PedidosPanel(List<Producto> listProductos){
		productos = new Vector<Producto>();
		this.setLayout(new BorderLayout());
		DefaultComboBoxModel productosModel = new DefaultComboBoxModel();
		inicLista(productosModel, listProductos);
		JComboBox productosList = new JComboBox(productosModel);
		JPanel listadoPanel = new JPanel();
		listadoPanel.add(productosList);
		JTextField cantidadTextField = new JTextField();
		listadoPanel.add(cantidadTextField);
		listadoPanel.setLayout(new GridLayout(1,3));
		JButton aceptarButton = new JButton("Aceptar");
		JButton cancelarButton = new JButton("Cancelar");
		JButton agregarButton = new JButton("Agregar");
		JPanel buttonPanel = new JPanel();
		listadoPanel.add(agregarButton);
		buttonPanel.add(aceptarButton);
		buttonPanel.add(cancelarButton);
		JPanel verListadoActual = new JPanel();
		DefaultListModel listadoActualModel = new DefaultListModel();
		JList listadoActualList = new JList(listadoActualModel);
		JScrollPane listadoScroll = new JScrollPane(listadoActualList);
		verListadoActual.add(listadoScroll);
		JButton borrarButton = new JButton("Borrar");
		verListadoActual.add(borrarButton);
		borrarButton.addActionListener(new BorrarListener(listadoActualList, listadoActualModel));
		agregarButton.addActionListener(new AgregarListener(productosList, cantidadTextField, listadoActualModel));
		this.add(verListadoActual,BorderLayout.CENTER);
		this.add(buttonPanel,BorderLayout.SOUTH);
		this.add(listadoPanel,BorderLayout.NORTH);
	}
	public void inicLista(DefaultComboBoxModel modelo, List<Producto> listProductos){
	//TODO acomodar ... tratar de hacer más genérica la creación de paneles.
		for(Producto producto : listProductos){
			//TODO puedo mostrar algo y guardar otra cosa?
			modelo.addElement(producto.getNombre());
		}
	}
	
	class BorrarListener implements ActionListener{
		JList lista;
		DefaultListModel modelo;
		public BorrarListener(JList list,DefaultListModel model){
			lista = list;
			modelo = model;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			if(lista.getSelectedIndex()!=-1){
				Producto aux = (Producto)lista.getSelectedValue();
				modelo.removeElement(aux);
				productos.removeElement(aux);
				System.out.println("Borrando "+ aux.toString());
			}
		}
	}
	class AgregarListener implements ActionListener{
		JComboBox combo;
		JTextField texto;
		DefaultListModel modelo;
		public AgregarListener(JComboBox comboBox,JTextField textField,DefaultListModel model){
			combo=comboBox;
			texto=textField;
			modelo = model;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				ProductoManager productoManager = new ProductoManager();
				if(combo.getSelectedIndex()!=-1){
					Producto aux = productoManager.getProductoByNombre(combo.getSelectedItem().toString());
					modelo.addElement(aux.getNombre());
					productos.addElement(aux);
					System.out.println("Agregando "+ aux.toString());
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}
	class CancelarListener implements ActionListener{
		public CancelarListener(){
			
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			
		}
	}
}
