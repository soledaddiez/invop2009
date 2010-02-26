package dao.impl;

import java.util.List;
import java.util.Vector;

import dao.GenericDAO;
import modelo.Formato;
import modelo.Linea;


public class LineaDAO extends GenericDAO<Linea>{
	public List<Linea> getLineas(){
		List<Linea> lineas = this.getList();
		List<Linea> lineas2 = new Vector<Linea>();
		for(Linea linea : lineas){
			Formato f = linea.getUltimoFormato();
			linea.setUltimoFormato(f);
			lineas2.add(linea);
		}
		return lineas2;
	}

	public Long getIdUltimoFormato(Long idLinea){
		List<Linea> lineas = this.getList();
		Long uf = null;
		for(Linea linea : lineas){
			if(linea.getId().equals(idLinea))
				uf = linea.getUltimoFormato().getId();
		}
		return uf;
	}
}
