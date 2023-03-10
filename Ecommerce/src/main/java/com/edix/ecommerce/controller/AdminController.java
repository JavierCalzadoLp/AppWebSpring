package com.edix.ecommerce.controller;

import java.util.Collections;
import java.util.Comparator;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.edix.ecommerce.modelo.beans.Pedido;
import com.edix.ecommerce.modelo.beans.PedidosProductos;
import com.edix.ecommerce.modelo.beans.Producto;
import com.edix.ecommerce.modelo.beans.Role;
import com.edix.ecommerce.modelo.beans.Usuario;
import com.edix.ecommerce.modelo.dao.PedidoDao;
import com.edix.ecommerce.modelo.dao.PedidosProductosDao;
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
	
	@Autowired
	PedidosProductosDao ppdao;
	
	
	
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
		
		@GetMapping("/{idUsuario}")
	    public String buscarPedidosPorCliente(Model model, @PathVariable int idUsuario) {
	        List<Pedido> listaPedidos = pedao.mostrarPedidoCliente(idUsuario);
	        Usuario user = udao.verUsuario(idUsuario);
	        
	        model.addAttribute("usuario", user);
	        if(user == null) {
	            model.addAttribute("pedidosDe", "No existe el usuario con id " + idUsuario);
	            return "usuarioPedidos";
	        }
	        model.addAttribute("pedidosDe","Pedidos del usuario " + user.getNombre());
	        model.addAttribute("listaPedidos",listaPedidos);

	        if(listaPedidos.size() != 0) {
	            
	        }else {
	            model.addAttribute("pedidosDe", user.getNombre() + " no tiene pedidos");
	            
	        }
	        return "usuarioPedidos";
	        
		}
	

	
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
		//pdao.modificarProducto(producto);
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
	
	@GetMapping("/pedidos")
	public String mostrarPedidos(Model model) {
		
		List<Pedido> listaPedidos = pedao.mostrarTodosPedidos();
		model.addAttribute("pedido", listaPedidos);
			
			return "pedidos";
	}
	
	//Ordenar lista productos
		@GetMapping("/ordenarPedidos")
		public String ordenarPedidos(@RequestParam("ordenarPor") String ordenarPor, Model model) {
		    List<Pedido> pedidos = pedao.mostrarTodosPedidos();
		    switch (ordenarPor) {
		        
		        case "fecha":
		            Collections.sort(pedidos, Comparator.comparing(Pedido::getFecha));
		            break;
		        
		        default:
		            break;
		    }
		    model.addAttribute("pedido", pedidos);
		    return "pedidos";
		}
	

	
	
	@GetMapping("/detallesPedidos/{id_pedido}")
	public String verPedidosCliente(Model model, @PathVariable("id_pedido") int idPedido) {
		
			//List<PedidosProductos> linea =  ppdao.buscarTodosPorIdPedido(idPedido);
			//model.addAttribute("linea", linea);
			//model.addAttribute("pedido", pedao.mostrarPedido(idPedido));
			List<PedidosProductos> linea = ppdao.mostrarTodos();
			model.addAttribute("linea", linea);
			
			return "detallePedidosProductos";
	}
	

	
	
	@GetMapping("/registro")
	public String registrar(Model model) {
		
		
		return "registroAdmin";
		 
		
	}
	
	@PostMapping("/registro")
	public String registrarUsuario(Model model,RedirectAttributes ratt,Usuario usuario, @RequestParam("nombre") String nombre ,
												@RequestParam("apellidos")String apellidos,
												@RequestParam("email")String email, 
												@RequestParam("fechaNacimiento") Date fechaNacimiento, 
												@RequestParam("password") String password ){
		
		Role r1 = new Role();
		r1.setIdRol(2);
		

	    //Usuario usuario = new Usuario();
	    usuario.setNombre(nombre);
	    usuario.setApellidos(apellidos);
	    usuario.setEmail(email);
	    usuario.setFechaNacimiento(usuario.getFechaNacimiento());
	    usuario.setEnabled(1);
	    usuario.setRole(r1);
	    //usuario.setFechaNacimiento(new Timestamp(fechaNacimiento.getTime())); /*Convertir fecha a TIMESTAMP*/
	   	// Encriptamos la contraseña
	    //usuario.setPassword(pwcript.encode(password));
	    usuario.setPassword(usuario.getPassword());
	    
	    String mensaje=null;
		//Comprobamos si el registro de usuario ha sido correcto
	    if(udao.altaUsuario(usuario) != 0) {
	    		usuario.setIdUsuario(usuario.getIdUsuario());
	    		//ratt.addAttribute("mensaje", "Alta usuario completada");
	    		ratt.addFlashAttribute("mensaje", "Alta Administrador completada");
	        return "redirect:/admin/registro";
	    } else {
	        //ratt.addAttribute("mensaje", "Ha ocurrido un error");
	        ratt.addFlashAttribute("mensaje", "Ha ocurrido un error");
	        return "/admin/registro";
	    }
	}
	
}
