package com.edix.ecommerce.modelo.dao;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edix.ecommerce.modelo.beans.PedidosProductos;
import com.edix.ecommerce.modelo.repository.PedidosProductosRepository;

@Service
public class PedidosProductosDaoImpl implements PedidosProductosDao{
	
	@Autowired
	private PedidosProductosRepository pprepo;
	
	@Override
	public BigDecimal totalVenta(int idPedido) {
	
		return pprepo.sumaTotal(idPedido);
	}

	@Override
	public List<PedidosProductos> pedidosProductosCliente(int idUsuario) {
		
		return pprepo.pedidosProductosCliente(idUsuario);
	}

}
