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
	public boolean registro(Producto producto) {
		if (findById(producto.getNombre()) == null) {
				prepo.save(producto);
				return true;
		}
		return false;
	}
	
	@Override
	public Producto findById(String nombre) {
		return prepo.findByNombre(nombre);
	}
	
	@Override
	public Producto findByIdReal(int id) {
		return prepo.findById(id);
	}
	
	@Override
	public int bajaProducto(int id) {
		int filas = 0;
		if(findByIdReal(id) != null) {
			try {
			prepo.deleteById(id);
			filas = 1;
			}catch(Exception e) {
				filas=0;
			}
		}
		return filas;
	}
	
	@Override
	public int cambiaProducto(Producto producto) {
		int cambia = 0;
		if(findByIdReal(producto.getIdProducto()) != null) {
			prepo.save(producto);
			cambia = 1;
		}
		return cambia;
	}

}
