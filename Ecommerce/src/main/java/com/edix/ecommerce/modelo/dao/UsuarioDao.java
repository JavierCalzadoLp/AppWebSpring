package com.edix.ecommerce.modelo.dao;

import com.edix.ecommerce.modelo.beans.Usuario;

public interface UsuarioDao {
	
	boolean registro(Usuario usuario);
	Usuario findById(String username);
	Usuario mostrarUsuario(String username);

}
