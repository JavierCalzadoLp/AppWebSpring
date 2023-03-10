package com.edix.ecommerce.modelo.dao;

import java.util.List;

import com.edix.ecommerce.modelo.beans.Role;

public interface RoleDao {

	
	List<Role> verRoles();
	Role verRole(int idRol);
	
	int altaRol(Role role);
	int modificarRol(Role role);
	int eliminarRol(int idRol);
}
