package com.edix.ecommerce.controller;

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
	
	@GetMapping("/prueba")
	public String Saludo() {
		
		return "prueba";
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
	
	@GetMapping("/")
	public String verTodos(Model model, Authentication aut) {
		
			List<Producto> lista = pdao.buscarTodos();
			model.addAttribute("listaTodos", lista);
			
			//TODO llamar como se llame la lista
			return "listaProductos";
	}
	
	@GetMapping("/registro")
	public String registrar(Model model) {
		
		
	//	model.addAttribute("mensaje", "registrando");
		
		return "registro";
		 
		
	}
	/*
	@PostMapping("/registro")
	public String proregistrar(Model model, Usuario usuario, RedirectAttributes ratt) {
		
		//MIRAR TEMA DE ROLES.
		
		usuario.setApellidos(usuario.getApellidos());
		usuario.setNombre(usuario.getNombre());
		usuario.setFechaNacimiento(usuario.getFechaNacimiento());
		usuario.setEmail(usuario.getEmail());
		usuario.setRole(2);
	 	usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
	 	
	 	//TODO Revisar con los JSP
	 	
	 	if (udao.registro(usuario)) {
	 		ratt.addFlashAttribute("mensaje", "alta realizada");
	 		return "redirect:/login";
	 	}
	 	else {
	 		model.addAttribute("mensaje", "ya existe como usuario");
	 		return "/inicioSesion";
	 		
	 	}
		
	}
	*/
	
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
