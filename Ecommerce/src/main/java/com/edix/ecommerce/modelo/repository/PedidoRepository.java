package com.edix.ecommerce.modelo.repository;

import java.util.Date;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.edix.ecommerce.modelo.beans.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer>{
	/*
	List<Pedido> findAllByFecha(Date date);
	
	List<Pedido> findAllByIdDireccione(int id);
	*/
	//Si esta query da problemas, probar con la de abajo por el tipo de fecha
	@Query("SELECT p FROM Pedido p WHERE p.fecha >= ?1")
	public List<Pedido> mostrarPedidosPorFecha(Date fecha);
	
	/*
	  @Query("SELECT p FROM Pedido p WHERE p.fecha >= STR_TO_DATE(?1, '%Y-%m-%d %H:%i:%s')")
		public List<Pedido> mostrarPedidosPorFecha(String fecha);

	 */
	
	@Query("SELECT p FROM Pedido p WHERE p.usuario.idUsuario = ?1")
	public List<Pedido> mostrarPedidosPorCliente(int idUsuario);

}
