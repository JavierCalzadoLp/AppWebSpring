package com.edix.ecommerce.modelo.dao;

import java.util.List;

import com.edix.ecommerce.modelo.beans.Producto;
import com.edix.ecommerce.modelo.beans.Tarjeta;

public interface ProductoDao {
	
	List<Producto> buscarTodos();
	//boolean registro(Producto producto);
	//public Producto findById(String nombre);
	//int bajaProducto(int id);
	//public Producto findByIdReal(int id);
	//int cambiaProducto(Producto producto);
	
	// Parte hecha por Javier
	
	List<Producto> verTodos();
	List<Producto> verProductosPorNombre(String nombre);
	Producto verProducto(int idProducto); //este es para ver DETALLE del producto
	
	int altaProducto(Producto producto);
	int eliminarProducto(int idProducto);
	int modificarProducto(Producto producto);
	

}
