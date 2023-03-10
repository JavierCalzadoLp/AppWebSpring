package com.edix.ecommerce.modelo.dao;

import java.util.List;

import com.edix.ecommerce.modelo.beans.Producto;
import com.edix.ecommerce.modelo.beans.Tarjeta;

public interface ProductoDao {
	
	List<Producto> buscarTodos();

	public Producto findByIdReal(int id);

	

	
	List<Producto> verTodos();
	List<Producto> verProductosPorNombre(String nombre);
	Producto verProducto(int idProducto); //este es para ver DETALLE del producto
	
	int altaProducto(Producto producto);
	int eliminarProducto(int idProducto);
	int modificarProducto(Producto producto);
	

	
	
	int buscarPorId (int idProducto);
	

	

}
