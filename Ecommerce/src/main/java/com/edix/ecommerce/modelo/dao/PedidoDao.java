package com.edix.ecommerce.modelo.dao;

import java.util.Date;
import java.util.List;

import com.edix.ecommerce.modelo.beans.Pedido;

public interface PedidoDao {
	
	//public List<Pedido> findAllByFecha(Date fecha);
	//public List<Pedido> findAllByIdDireccione(int id);
	
	int nuevoPedido(Pedido pedido);
	List<Pedido> mostrarPedidoFecha(Date fecha);
	List<Pedido> mostrarPedidoCliente(int idUsuario);
	Pedido mostrarPedido(int idPedido);

}
