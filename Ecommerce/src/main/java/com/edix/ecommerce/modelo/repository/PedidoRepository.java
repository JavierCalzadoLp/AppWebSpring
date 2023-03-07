package com.edix.ecommerce.modelo.repository;

import java.util.Date;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edix.ecommerce.modelo.beans.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer>{
	/*
	List<Pedido> findAllByFecha(Date date);
	
	List<Pedido> findAllByIdDireccione(int id);
	*/

}
