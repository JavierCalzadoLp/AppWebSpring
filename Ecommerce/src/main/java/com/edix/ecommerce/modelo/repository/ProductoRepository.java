package com.edix.ecommerce.modelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edix.ecommerce.modelo.beans.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer>{

}
