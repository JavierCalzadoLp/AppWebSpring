package com.edix.ecommerce.controller;

import java.util.Date;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.edix.ecommerce.modelo.beans.Pedido;
import com.edix.ecommerce.modelo.beans.Producto;
import com.edix.ecommerce.modelo.dao.PedidoDao;
import com.edix.ecommerce.modelo.dao.ProductoDao;
import com.edix.ecommerce.modelo.dao.RoleDao;
import com.edix.ecommerce.modelo.dao.UsuarioDao;



@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	UsuarioDao udao;
	@Autowired
	ProductoDao pdao;
	@Autowired
	RoleDao rdao;
	@Autowired
	PedidoDao pedao;
	
	
	
	@GetMapping("/misDatos")
	public String misDatos(Authentication aut, Model model) {
		
		model.addAttribute("cliente", udao.mostrarUsuario(aut.getUsername()));
		
		return "misdatos";
		
	}
	
	@PostMapping("/newProducto")
	public String newProducto(Model model, Producto producto, RedirectAttributes ratt) {	
		
		producto.setDescripcion(producto.getDescripcion());
		producto.setNombre(producto.getNombre());
		producto.setPrecio(producto.getPrecio());
		producto.setStock(producto.getStock());
		
	 	//TODO Revisar con los JSP
	 	
	 	if (pdao.registro(producto)) {
	 		ratt.addFlashAttribute("mensaje", "alta realizada");
	 		return "redirect:/misdatos";
	 	}
	 	else {
	 		model.addAttribute("mensaje", "ya existe el producto");
	 		return "/misdatos";
	 		
	 	}
		
	}
	
	@GetMapping("/eliminarProducto/{idProducto}")
	public String eliminarProducto(@PathVariable("id") int id, Model model) {
		String mensaje = null;
		if (pdao.bajaProducto(id) == 1)
			mensaje = "Producto eliminado correctamente";
		else
			mensaje = "Producto con dependencias: NO se ha podido eliminar";
		
		model.addAttribute("mensaje", mensaje);
		return "forward:/";
			
	}
	
	
	@GetMapping("/editar/{id}")
	public String enviarFormularioEditar(Model model, @PathVariable(name="id") int codigo) {
		
		 
		
		model.addAttribute("producto", pdao.findByIdReal(codigo));
		return "formProductoEditar";
		 
	}
	
	@PostMapping("/modificar")
	public String procesarFormularioEditar(Model model,Producto producto ) {
		
		
		System.out.println(producto);
		
	 	pdao.cambiaProducto(producto);
	 
		
	  	return "redirect:/";
		 
		 
	}
	
	
	@GetMapping("/editarRole/{id}")
	public String editarRole(Model model, @PathVariable(name="id") int id) {
		
		model.addAttribute("rol", rdao.findById(id));
		return "admin";
		
		//TODO AÑADIR MENSAJE?
		 
		
	}
	
	/*
	@GetMapping("/pedidosDia/{fecha}")
	public String verPedidosDia(Model model, Authentication aut, @PathVariable(name="fecha")Date fecha) {
		
			List<Pedido> lista = pedao.findAllByFecha(fecha);
			model.addAttribute("listaTodos", lista);
			
			//TODO llamar como se llame la lista
			return "listaPedidos";
	}
	*/
	/*
	@GetMapping("/pedidos/{id}")
	public String verPedidosCliente(Model model, Authentication aut, @PathVariable(name="id")int id) {
		
			List<Pedido> lista = pedao.findAllByIdDireccione(id);
			model.addAttribute("listaTodos", lista);
			
			//TODO llamar como se llame la lista HABRIA QUE CREAR BEAN DE LA TABLA INTERMEDIA????
			return "listaPedidosCliente";
	}
	*/
	
}
