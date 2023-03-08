package com.edix.ecommerce.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.edix.ecommerce.modelo.beans.Producto;
import com.edix.ecommerce.modelo.beans.Usuario;
import com.edix.ecommerce.modelo.dao.ProductoDaoImpl;
import com.edix.ecommerce.modelo.dao.RoleDaoImpl;
import com.edix.ecommerce.modelo.dao.UsuarioDao;

import javax.servlet.http.HttpSession;


//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.crypto.password.PasswordEncoder;


@Controller
public class HomeController {
	@Autowired
	ProductoDaoImpl pdao;
	@Autowired
	RoleDaoImpl rdao;
	@Autowired
	UsuarioDao udao;
	//@Autowired
	//private PasswordEncoder passwordEncoder;
	
	@GetMapping("/inicio")
	public String Saludo() {
		
		return "inicio";
	}
	
	@GetMapping("/todosProductos")
	public String verProductos(Model model) {
		List<Producto> listaProductos = pdao.verTodos();
		model.addAttribute("productos", listaProductos);
		return "todosProductos";
	}
	
	@GetMapping("/detalleProducto")
	public String detalleProducto(@RequestParam("id_producto") int idProducto, Model model) {
		Producto producto = pdao.verProducto(idProducto);
		model.addAttribute("producto", producto);
		return "detalleProducto";
	}
	
	//Ordenar lista productos
	@GetMapping("/ordenarProductos")
	public String ordenarProductos(@RequestParam("ordenarPor") String ordenarPor, Model model) {
	    List<Producto> productos = pdao.buscarTodos();
	    switch (ordenarPor) {
	        case "idProducto":
	            Collections.sort(productos, Comparator.comparing(Producto::getIdProducto));
	            break;
	        case "nombre":
	            Collections.sort(productos, Comparator.comparing(Producto::getNombre));
	            break;
	        case "descripcion":
	            Collections.sort(productos, Comparator.comparing(Producto::getDescripcion));
	            break;
	        case "precio":
	            Collections.sort(productos, Comparator.comparing(Producto::getPrecio));
	            break;
	        default:
	            break;
	    }
	    model.addAttribute("productos", productos);
	    return "todosProductos";
	}

	//Buscar productos por nombre
	
	@GetMapping("/buscarProductos")
	public String buscarProductos(@RequestParam("busqueda") String busqueda, Model model) {
	    List<Producto> productos = pdao.buscarTodos();
	    List<Producto> productosFiltrados = new ArrayList<>();
	    for (Producto producto : productos) {
	        if (producto.getNombre().toLowerCase().contains(busqueda.toLowerCase())) {
	            productosFiltrados.add(producto);
	        }
	    }
	    model.addAttribute("productos", productosFiltrados);
	    return "todosProductos";
	}

	
	
	/*
	@GetMapping("/")
	public String verTodos(Model model, Authentication aut) {
		
			List<Producto> lista = pdao.buscarTodos();
			model.addAttribute("listaTodos", lista);
			
			//TODO llamar como se llame la lista
			return "listaProductos";
	}
	*/
	
	@GetMapping("/registro")
	public String registrar(Model model) {
		
		
		return "registro";
		 
		
	}
	
	
	@PostMapping("/registro")
	public String proregistrar(Model model, Usuario usuario, RedirectAttributes ratt) throws ParseException {
		
		
		
		usuario.setApellidos(usuario.getApellidos());
		usuario.setNombre(usuario.getNombre());
		
		
		//String tempdate = usuario.getFechaNacimiento().toString();
		
		//Date date1= new SimpleDateFormat("yyyy-MM-dd").parse(tempdate);
		
		//Date date1= new SimpleDateFormat("yyyy-MM-dd").parse(tempdate);

		    
		//usuario.setFechaNacimiento(date1);
		usuario.setFechaNacimiento(usuario.getFechaNacimiento());
		usuario.setEmail(usuario.getEmail());
		//usuario.setRole(1);
		usuario.setEnabled(1);
	 	usuario.setPassword(usuario.getPassword());
	 	
	 
	 	
	 	if (udao.altaUsuario(usuario) != 0) {
	 		ratt.addFlashAttribute("mensaje", "alta realizada");
	 		return "redirect:/registro";
	 	}
	 	else {
	 		model.addAttribute("mensaje", "ya existe como usuario");
	 		return "/registro";
	 		
	 	}
		
	}
	
	
	@GetMapping("/error")
	public String procesarError() {
		
		 
		System.out.println("procesar error");
		
		return "pruebas";
	}
	
	//TODO inicio de sesión
	
	/*
	@GetMapping("/index")
	public String procesarLogin(Authentication aut, Model model, HttpSession misesion) {
		
		System.out.println("Usuario : " + aut.getUsername());
		Usuario usuario = udao.findById(aut.getUsername());
		
		if (misesion.getAttribute("usuario") == null)
			misesion.setAttribute("usuario", usuario);
		
		System.out.println();
		
		for (GrantedAuthority ele: aut.getAuthorities())
			System.out.println("ROLE : " + ele.getAuthority());
		
		model.addAttribute("mensaje", aut.getAuthorities());
		
		
		return "redirect:/";
	}
	*/
	

}
