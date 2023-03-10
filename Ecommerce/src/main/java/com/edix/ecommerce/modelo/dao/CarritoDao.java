package com.edix.ecommerce.modelo.dao;

import java.util.Map;

import com.edix.ecommerce.modelo.beans.Producto;
import com.edix.ecommerce.modelo.beans.Usuario;



public interface CarritoDao {

	void addProductoCarrito(Map<Producto,Integer> carrito, Integer idProducto);
	void eliminateProductoCarrito(Map<Producto,Integer> carrito, Integer idProducto);
	void saveCarrito(Map<Producto,Integer> carrito, Usuario usuario);
	Map<Producto,Integer> recuperarCarrito(Integer idUsuario);
	
	

}
