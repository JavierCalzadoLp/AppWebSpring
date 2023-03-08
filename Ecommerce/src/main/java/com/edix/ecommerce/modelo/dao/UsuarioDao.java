package com.edix.ecommerce.modelo.dao;

import java.util.List;

import com.edix.ecommerce.modelo.beans.Direccione;
import com.edix.ecommerce.modelo.beans.Role;
import com.edix.ecommerce.modelo.beans.Tarjeta;
import com.edix.ecommerce.modelo.beans.Usuario;

public interface UsuarioDao {
	
	//boolean registro(Usuario usuario);
	//Usuario findById(String username);
	//Usuario mostrarUsuario(String username);
	
	
	
	int modificarRol(Usuario usuario);
	
	
	List<Usuario> verTodos();
	
	Usuario verUsuario(int idUsuario);
	
	int altaUsuario(Usuario usuario);
	int eliminarUsuario(int idUsuario);
	int modificarUsuario(Usuario usuario);
	
	List<Tarjeta> addTarjetaUsuario(Usuario usuario, Tarjeta tarjeta);
	List<Tarjeta> removeTarjetaUsuario(Usuario usuario, Tarjeta tarjeta);
	
	List<Direccione> addDireccioneUsuario(Usuario usuario, Direccione direccione);
	List<Direccione> removeDireccioneUsuario(Usuario usuario, Direccione direccione);
	
	
	
	
	
	

}
