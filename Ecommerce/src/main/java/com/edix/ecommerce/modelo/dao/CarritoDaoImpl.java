package com.edix.ecommerce.modelo.dao;

import java.math.BigDecimal;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edix.ecommerce.modelo.beans.Pedido;
import com.edix.ecommerce.modelo.beans.PedidosProductos;
import com.edix.ecommerce.modelo.beans.Producto;
import com.edix.ecommerce.modelo.beans.Usuario;
import com.edix.ecommerce.modelo.repository.PedidoRepository;
import com.edix.ecommerce.modelo.repository.PedidosProductosRepository;

@Service
public class CarritoDaoImpl implements CarritoDao {

	@Autowired ProductoDao pdao;
	@Autowired PedidoDao pedao;
	@Autowired PedidosProductosDao ppdao;
	@Autowired PedidoRepository prepo;
	@Autowired PedidosProductosRepository pprepo;


	@Override
	public void addProductoCarrito(Map<Producto, Integer> carrito, Integer idProducto) {
		Producto producto = pdao.verProducto(idProducto);

		if (carrito.containsKey(producto)) {
			int cantActual = carrito.get(producto);
			int cantAumentada = ++cantActual;
			if (cantAumentada <= 10) {
				carrito.put(producto, cantAumentada);
			}

		} else {
			carrito.put(producto, 1);
		}

	}
	
	
	
	@Override
	public void eliminateProductoCarrito(Map<Producto, Integer> carrito, Integer idProducto) {
		Producto producto = pdao.verProducto(idProducto);

		if (carrito.containsKey(producto)) {
			int cantActual = carrito.get(producto);
			cantActual--;
			if (cantActual == 0) {
				carrito.remove(producto);
			} else {
				carrito.put(producto, cantActual);
			}
		}
	}


	
	@Override
	public void saveCarrito(Map<Producto, Integer> carrito, Usuario usuario) {
		if (carrito != null) {
			Pedido pedido = prepo.mostrarPedidoCarritoPorCliente(usuario.getIdUsuario());


			if (pedido == null) pedido = new Pedido();

			Date fechaActual = new Date();
			String estadoCarrito = "CARRITO";

			pedido.setFecha(fechaActual);
			pedido.setUsuario(usuario);
			pedido.setEstado(estadoCarrito);
			
			

			List<PedidosProductos> productos = pedido.getPedidosproductos();

			if (productos != null && !productos.isEmpty())
				//prepo.deleteById(productos);
				prepo.deleteAllInBatch();

			
			Pedido pedidoGuardado = prepo.save(pedido);

			for (Map.Entry<Producto, Integer> entry : carrito.entrySet()) {

				PedidosProductos productosPedido = new PedidosProductos();
				BigDecimal cantidad = new BigDecimal(entry.getValue());
				BigDecimal precio = entry.getKey().getPrecio();
				BigDecimal precioTotal = cantidad.multiply(precio);

				productosPedido.setPedido(pedidoGuardado);
				productosPedido.setProducto(entry.getKey());
				productosPedido.setUnidades((int) entry.getValue());
				productosPedido.setPrecio_venta(precioTotal);

				prepo.save(productosPedido);
			}

		}
	}


	@Override
	public Map<Producto, Integer> recuperarCarrito(Integer idUsuario) {
		Map<Producto, Integer> carrito = new HashMap<>();
		List<PedidosProductos> productosEnPedidoLista = pprepo.ProductosEnPedidoPorUsuario(idUsuario);

		for (PedidosProductos pep : productosEnPedidoLista) {
			Producto producto = pep.getProducto();
			Integer cantidad = pep.getUnidades();

			carrito.put(producto, cantidad);
		}

		return carrito;

	}
}



