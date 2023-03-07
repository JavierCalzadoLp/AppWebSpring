package com.edix.ecommerce.modelo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edix.ecommerce.modelo.beans.Role;
import com.edix.ecommerce.modelo.repository.RoleRepository;

@Service
public class RoleDaoImpl implements RoleDao{
	
	@Autowired
	RoleRepository rrepo;
	
	@Override
	public Role findById(int id) {
		return rrepo.findById(id);
	}
	/*
	public Role editarRole(RoleUsuario role) {
		
		int cambia = 0;
		if(findByIdReal(producto.getIdProducto()) != null) {
			prepo.save(producto);
			cambia = 1;
		}
		return cambia;
		
	}
	*/
	
	//TODO CREAR BEAN ROLE USUARIO PARA PODER EDITAR LA TABLA??
	

}
