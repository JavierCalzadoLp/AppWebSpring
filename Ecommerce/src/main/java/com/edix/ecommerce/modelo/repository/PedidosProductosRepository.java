package com.edix.ecommerce.modelo.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.edix.ecommerce.modelo.beans.PedidosProductos;

public interface PedidosProductosRepository extends JpaRepository<PedidosProductos, Integer>{
	
	@Query("SELECT sum(pp.precio_venta) FROM PedidosProductos pp WHERE pp.pedido.idPedido = ?1")
	public BigDecimal sumaTotal(int idPedido);
	
	@Query("SELECT pp FROM PedidosProductos pp WHERE pp.pedido.usuario.idUsuario = ?1")
	public List<PedidosProductos> pedidosProductosCliente(int idUsuario);

}
