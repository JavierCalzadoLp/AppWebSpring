package com.edix.ecommerce.modelo.dao;

import java.math.BigDecimal;
import java.util.List;

import com.edix.ecommerce.modelo.beans.PedidosProductos;

public interface PedidosProductosDao {
	
	BigDecimal totalVenta(int idPedido);
	List<PedidosProductos> pedidosProductosCliente(int idUsuario);

}
