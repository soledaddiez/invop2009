package dao.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;

import modelo.Demanda;
import modelo.Pedido;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import dao.GenericDAO;

public class PedidoDAO extends GenericDAO<Pedido>{

	public List<Demanda> getDemandas(Timestamp fechaInicio){
		List<Demanda> demandas = new ArrayList<Demanda>();

		List<Pedido> pedidos = this.getPedidosDesdeFecha(fechaInicio);
		
		Hashtable<String, Demanda> hash = new Hashtable<String, Demanda>();
		Demanda demanda;

		for(Pedido pedido : pedidos){
			
			if(hash.containsKey(pedido.getProducto().getId()+"-"+pedido.getFechaOrden().toString())){
				demanda = hash.get(pedido.getProducto().getId()+"-"+pedido.getFechaOrden().toString());
				demanda.setCantidad(demanda.getCantidad()+pedido.getCantidad());
				hash.put(pedido.getProducto().getId()+"-"+pedido.getFechaOrden().toString(), demanda);
			}
			else{
				demanda = new Demanda(pedido.getProducto(), pedido.getCantidad(), pedido.getFechaOrden());
				hash.put(pedido.getProducto().getId()+"-"+pedido.getFechaOrden().toString(), demanda);
			}
		}
		
		for(Enumeration en=hash.keys(); en.hasMoreElements(); ){
			demandas.add(hash.get(en.nextElement()));
		}

		return demandas;
	}
	
	/**
	 * Obtiene todos los pedidos a partir de una fecha dada.
	 * @param fechaInicio
	 * @return listado de pedidos existentes.
	 */
	public List<Pedido> getPedidosDesdeFecha(Timestamp fechaInicio){
		Criteria crit = getHibernateTemplate().createCriteria(domainClass.getName());
		if (fechaInicio != null){
			crit.add(Restrictions.ge("fechaOrden", fechaInicio));	
		}
		
		List<Pedido> returnList = crit.list(); 
		session.getTransaction().commit();
		return returnList;
	}
}
