package com.edix.ecommerce.modelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edix.ecommerce.modelo.beans.Direccione;
import com.edix.ecommerce.modelo.beans.Tarjeta;
import com.edix.ecommerce.modelo.beans.UsuarioDireccione;

public interface DireccioneRepository extends JpaRepository<Direccione, Integer>{
	
	//Direccione findByDireccion(String direccion);


}
