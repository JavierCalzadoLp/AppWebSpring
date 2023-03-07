package com.edix.ecommerce.modelo.dao;

import java.util.Date;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edix.ecommerce.modelo.beans.Pedido;
import com.edix.ecommerce.modelo.repository.PedidoRepository;

@Service
public class PedidoDaoImpl implements PedidoDao{
	
	@Autowired
	PedidoRepository prepo;

	@Override
	public int nuevoPedido(Pedido pedido) {
		int filas=0;
		try {
			prepo.save(pedido);
			filas=1;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return filas;
	}

	@Override
	public List<Pedido> mostrarPedidoFecha(Date fecha) {
		
		return prepo.mostrarPedidosPorFecha(fecha);
	}

	@Override
	public List<Pedido> mostrarPedidoCliente(int idUsuario) {
	
		return prepo.mostrarPedidosPorCliente(idUsuario);
	}

	@Override
	public Pedido mostrarPedido(int idPedido) {
		
		return prepo.findById(idPedido).orElse(null);
	}
	
	/*
	@Override
	public List<Pedido> findAllByFecha(Date fecha) {
		// TODO Auto-generated method stub
		return prepo.findAllByFecha(fecha);
	}
	
	public List<Pedido> findAllByIdDireccione(int id){
		return prepo.findAllByIdDireccione(id);
		
	}
	*/

}
