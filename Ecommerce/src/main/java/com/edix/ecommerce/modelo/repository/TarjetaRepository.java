package com.edix.ecommerce.modelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edix.ecommerce.modelo.beans.Tarjeta;
import com.edix.ecommerce.modelo.beans.Usuario;

public interface TarjetaRepository extends JpaRepository<Tarjeta, Integer>{
	
	//Tarjeta findByNumTarjeta(String numTarjeta);

}
