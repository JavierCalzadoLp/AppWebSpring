package com.edix.ecommerce.modelo.dao;

import java.util.List;

import com.edix.ecommerce.modelo.beans.Direccione;
import com.edix.ecommerce.modelo.beans.Tarjeta;
import com.edix.ecommerce.modelo.beans.UsuarioDireccione;

public interface DireccioneDao {
	
	//boolean registro(Direccione direccion);
	//public Direccione findById(String direccion);
	
	List<Direccione> verTodas();
	
	Direccione verDireccione(int idDireccion);
	
	int altaDireccion(Direccione direccione);
	int eliminarDireccion(int idDireccion);
	int modificarDireccion(Direccione direccione);


}
