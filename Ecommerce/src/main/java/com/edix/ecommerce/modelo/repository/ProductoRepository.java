package com.edix.ecommerce.modelo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.edix.ecommerce.modelo.beans.Producto;


public interface ProductoRepository extends JpaRepository<Producto, Integer>{
	
	
	@Query("SELECT p FROM Producto p WHERE p.nombre = :nombre")
	List<Producto> buscarPorNombre(@Param("nombre") String nombre);
	
	Producto findByNombre(String nombre);
	
	Producto findById(int id);

}
