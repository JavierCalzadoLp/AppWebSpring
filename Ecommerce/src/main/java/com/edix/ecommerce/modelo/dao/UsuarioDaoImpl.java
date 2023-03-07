package com.edix.ecommerce.modelo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edix.ecommerce.modelo.beans.Direccione;
import com.edix.ecommerce.modelo.beans.Role;
import com.edix.ecommerce.modelo.beans.Tarjeta;
import com.edix.ecommerce.modelo.beans.Usuario;
import com.edix.ecommerce.modelo.repository.UsuarioRepository;

@Service
public class UsuarioDaoImpl implements UsuarioDao{
	
	@Autowired
	private UsuarioRepository urepo;

	@Override
	public List<Usuario> verTodos() {
	
		return urepo.findAll();
	}

	@Override
	public Usuario verUsuario(int idUsuario) {
		// TODO Auto-generated method stub
		return urepo.findById(idUsuario).orElse(null);
	}

	@Override
	public int altaUsuario(Usuario usuario) {
		int filas=0;
		try {
			urepo.save(usuario);
			filas = 1;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return filas;
	}

	@Override
	public int eliminarUsuario(int idUsuario) {
		int filas=0;
		try {
			urepo.deleteById(idUsuario);
			filas = 1;
		}catch(Exception e){
			e.printStackTrace();
		}
		return filas;
	}

	@Override
	public int modificarUsuario(Usuario usuario) {
		int filas=0;
		if(verUsuario(usuario.getIdUsuario()) != null) {
			urepo.save(usuario);
			filas=1;
		}
		return filas;
	}

	@Override
	public List<Tarjeta> addTarjetaUsuario(Usuario usuario, Tarjeta tarjeta) {
		List<Tarjeta> tarjetas = usuario.getTarjetas();
	    tarjetas.add(tarjeta);
	    usuario.setTarjetas(tarjetas);
		//session.saveOrUpdate(usuario);
		return tarjetas;
	    
	}

	@Override
	public List<Tarjeta> removeTarjetaUsuario(Usuario usuario, Tarjeta tarjeta) {
		List<Tarjeta> tarjetas = usuario.getTarjetas();
	    tarjetas.remove(tarjeta);
	    usuario.setTarjetas(tarjetas);
	    //session.update(usuario);
	    return tarjetas;
	
	}

	@Override
	public List<Direccione> addDireccioneUsuario(Usuario usuario, Direccione direccione) {
		List<Direccione> direcciones = usuario.getDirecciones();
		direcciones.add(direccione);
		usuario.setDirecciones(direcciones);
		return direcciones;
	}

	@Override
	public List<Direccione> removeDireccioneUsuario(Usuario usuario, Direccione direccione) {
		List<Direccione> direcciones = usuario.getDirecciones();
	    direcciones.remove(direccione);
	    usuario.setDirecciones(direcciones);
	    //session.update(usuario);
	    return direcciones;
	}

	@Override
	public List<Role> addRoleUsuario(Usuario usuario, Role role) {
		List<Role> roles = usuario.getRoles();
		roles.add(role);
		usuario.setRoles(roles);
		return roles;
	}

	@Override
	public List<Role> removeRoleUsuario(Usuario usuario, Role role) {
		List<Role> roles = usuario.getRoles();
	    roles.remove(role);
	    usuario.setRoles(roles);
	    //session.update(usuario);
	    return roles;
	}
	
	
	
	
	
	/*
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
*/
}
