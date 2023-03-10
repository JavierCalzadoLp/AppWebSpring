package com.edix.ecommerce.modelo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edix.ecommerce.modelo.beans.Producto;
import com.edix.ecommerce.modelo.repository.ProductoRepository;

@Service
public class ProductoDaoImpl implements ProductoDao{
	
	@Autowired
	ProductoRepository prepo;
	
	@Override
	public List<Producto> buscarTodos() {
		// TODO Auto-generated method stub
		return prepo.findAll();
	}


	
	@Override
	public Producto findByIdReal(int id) {
		return prepo.findById(id).orElse(null);
	}
	


	@Override
	public List<Producto> verTodos() {
		
		return prepo.findAll();
	}


	@Override
	public List<Producto> verProductosPorNombre(String nombre) {
		
		return prepo.buscarPorNombre(nombre);
	}

	//Este es para ver el detalle del producto
	@Override
	public Producto verProducto(int idProducto) {
		
		return prepo.findById(idProducto).orElse(null);
		
	}
	

	@Override
	public int altaProducto(Producto producto) {
		int filas = 0;
		try {
			prepo.save(producto);
			filas = 1;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return filas;
	}


	@Override
	public int eliminarProducto(int idProducto) {
		int filas = 0;
		try {
			prepo.deleteById(idProducto);
			filas=1;
		}catch(Exception e){
			e.printStackTrace();
		}
		return filas;
	}


	@Override
	public int modificarProducto(Producto producto) {
		int filas=0;
		
			prepo.save(producto);
		return filas;
	}

	@Override
	public int buscarPorId(int idProducto) {
		
		return prepo.buscarPorId(idProducto);
	}


}
