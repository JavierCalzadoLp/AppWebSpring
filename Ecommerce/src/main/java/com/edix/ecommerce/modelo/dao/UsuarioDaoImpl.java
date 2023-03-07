package com.edix.ecommerce.modelo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edix.ecommerce.modelo.beans.Usuario;
import com.edix.ecommerce.modelo.repository.UsuarioRepository;

@Service
public class UsuarioDaoImpl implements UsuarioDao{
	
	@Autowired
	private UsuarioRepository urepo;
	
	@Override
	public Usuario findById(String nombre) {
		return urepo.findByNombre(nombre);
	}
	
	@Override
	public boolean registro(Usuario usuario) {
		if (findById(usuario.getNombre()) == null) {
				urepo.save(usuario);
				return true;
		}
		return false;
	}
	
	@Override
	public Usuario mostrarUsuario(String nombre) {
		
		return urepo.findByNombre(nombre);
	}

}
