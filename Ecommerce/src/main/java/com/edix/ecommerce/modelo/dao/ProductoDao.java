package com.edix.ecommerce.modelo.dao;

import java.util.List;

import com.edix.ecommerce.modelo.beans.Producto;
import com.edix.ecommerce.modelo.beans.Tarjeta;

public interface ProductoDao {
	
	List<Producto> buscarTodos();
	boolean registro(Producto producto);
	public Producto findById(String nombre);
	int bajaProducto(int id);
	public Producto findByIdReal(int id);
	int cambiaProducto(Producto producto);
	

}
