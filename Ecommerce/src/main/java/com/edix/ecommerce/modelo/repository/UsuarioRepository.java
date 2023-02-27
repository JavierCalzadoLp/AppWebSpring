package com.edix.ecommerce.modelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edix.ecommerce.modelo.beans.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

}
