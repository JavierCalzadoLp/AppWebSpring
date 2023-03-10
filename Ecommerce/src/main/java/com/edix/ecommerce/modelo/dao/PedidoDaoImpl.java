package com.edix.ecommerce.modelo.dao;

import java.util.Date;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edix.ecommerce.modelo.beans.Pedido;
import com.edix.ecommerce.modelo.beans.PedidosProductos;
import com.edix.ecommerce.modelo.beans.Producto;
import com.edix.ecommerce.modelo.repository.PedidoRepository;
import com.edix.ecommerce.modelo.repository.ProductoRepository;

@Service
public class PedidoDaoImpl implements PedidoDao{
	
	@Autowired
	PedidoRepository prepo;
	@Autowired
    ProductoRepository perepo;

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
	
	
	@Override
	public List<Pedido> findAllByFecha(Date fecha) {
		// TODO Auto-generated method stub
		return prepo.findAllByFecha(fecha);
	}

	@Override
    public boolean byeStock(Pedido pedido) {
        List<PedidosProductos> listaPep = prepo.buscarTodosPorIdPedido(pedido.getIdPedido());

        for (PedidosProductos pep : listaPep) {
            Producto producto = pep.getProducto();
            int cantidad = pep.getUnidades();

            int stock = perepo.verStock(pep.getProducto().getIdProducto());
            if (stock > 0) { 
                producto.setStock(stock - cantidad);
                perepo.save(producto);
            }else
                return false;
        }

        return true;

    }

	@Override
	public List<Pedido> mostrarTodosPedidos() {
		
		return prepo.findAll();
	}
	

}
