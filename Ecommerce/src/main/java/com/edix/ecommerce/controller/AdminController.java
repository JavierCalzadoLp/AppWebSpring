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
import com.edix.ecommerce.modelo.beans.Role;
import com.edix.ecommerce.modelo.beans.Usuario;
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
	
	
	
	//VER USUARIOS
	
		@GetMapping("/verUsuarios")
		public String verUsuarios(Model model) {
			
			List<Usuario> listaUsuarios = udao.verTodos();
			model.addAttribute("usuarios", listaUsuarios);
			
			return "verUsuarios";
		}
		
		//DAR DE ALTA UN PRODUCTO
		
		@GetMapping("/altaProducto")
		public String mostrarFormAlta() {
			
			return "formAltaProducto";
		}
		
		@PostMapping("/altaProducto")
		public String newProducto(Model model, Producto producto, RedirectAttributes ratt) {	
			
			producto.setDescripcion(producto.getDescripcion());
			producto.setNombre(producto.getNombre());
			producto.setPrecio(producto.getPrecio());
			producto.setStock(producto.getStock());
			
		 	
		 	
		 	if (pdao.altaProducto(producto) != 0) {
		 		ratt.addFlashAttribute("mensaje", "Alta Realizada");
		 		return "redirect:/admin/altaProducto";
		 	}
		 	else {
		 		model.addAttribute("mensaje", "ya existe el producto");
		 		return "/admin/altaProducto";
		 		
		 	}
			
		}
		
	
	
	/*
	@GetMapping("/misDatos")
	public String misDatos(Authentication aut, Model model) {
		
		model.addAttribute("cliente", udao.mostrarUsuario(aut.getUsername()));
		
		return "misdatos";
		
	}
	*/
	
	@GetMapping("/eliminarProducto")
	public String eliminarProducto(Model model) {
		List<Producto> listaTodos = pdao.verTodos();
		model.addAttribute("producto", listaTodos);
		return "eliminarProducto";
	}
	
	
	
	@GetMapping("/eliminarProducto/{idProducto}")
	public String eliminarProducto(@PathVariable("idProducto") int idProducto, Model model) {

		
		String mensaje = null;
		if (pdao.eliminarProducto(idProducto) != 0)
			mensaje = "Producto eliminado correctamente";
		else
			mensaje = "Producto con dependencias: NO se ha podido eliminar";
		
		model.addAttribute("mensaje", mensaje);
		return "forward:/admin/eliminarProducto";
			
	}
	
	
	
	@GetMapping("/editar/{id}")
	public String enviarFormularioEditar(Model model, @PathVariable(name="id") int codigo) {
		
		 
		model.addAttribute("producto", pdao.verProducto(codigo));
		
		return "editarProducto";
		 
	}
	
	@PostMapping("/modificar")
	public String procesarFormularioEditar(Model model,Producto producto ) {
		
		String mensaje =null;
		System.out.println(producto);
		/*
		if(pdao.modificarProducto(producto) != 0)
			mensaje = "Producto editado correctamente";
		else
			mensaje= "Producto no se puede editar";
		*/
		pdao.modificarProducto(producto);
		
		model.addAttribute("mensaje", mensaje);
	 
		
	  	return "redirect:/admin/eliminarProducto";
		 
	
	}
	
	
	
	@GetMapping("/editarRole/{id}")
	public String editarRole(Model model, @PathVariable("id") int id) {
		
		model.addAttribute("rol", udao.verUsuario(id));
		
		return "editarRole";
		
		 
		
	}
	
	@PostMapping("/modificarRole")
	public String procesarFormularioEditarRole(Model model,Usuario usuario ) {
		
		String mensaje =null;
		
		/*
		if(pdao.modificarProducto(producto) != 0)
			mensaje = "Producto editado correctamente";
		else
			mensaje= "Producto no se puede editar";
		*/
		
		udao.modificarRol(usuario);
		
		model.addAttribute("mensaje", mensaje);
	 
		
	  	return "redirect:/admin/verUsuarios";
		 
	
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
