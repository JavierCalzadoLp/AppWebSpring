package com.edix.ecommerce.modelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edix.ecommerce.modelo.beans.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{
	
	Role findById(int id);

}
