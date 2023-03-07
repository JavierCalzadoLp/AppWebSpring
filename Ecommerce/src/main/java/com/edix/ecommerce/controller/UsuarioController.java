package com.edix.ecommerce.controller;

import java.util.Date;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.edix.ecommerce.modelo.beans.Direccione;
import com.edix.ecommerce.modelo.beans.Producto;
import com.edix.ecommerce.modelo.beans.Tarjeta;
import com.edix.ecommerce.modelo.beans.Usuario;
import com.edix.ecommerce.modelo.beans.UsuarioDireccione;
import com.edix.ecommerce.modelo.dao.DireccioneDao;
import com.edix.ecommerce.modelo.dao.ProductoDaoImpl;
import com.edix.ecommerce.modelo.dao.RoleDaoImpl;
import com.edix.ecommerce.modelo.dao.TarjetaDao;
import com.edix.ecommerce.modelo.dao.UsuarioDao;

import javax.servlet.http.HttpSession;

/*
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;

*/
@Controller
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	UsuarioDao udao;
	@Autowired
	TarjetaDao tdao;
	@Autowired
	DireccioneDao ddao;
	
	/*
	@GetMapping("/misDatos")
	public String misDatos(Authentication aut, Model model) {
		
		model.addAttribute("cliente", udao.mostrarUsuario(aut.getUsername()));
		
		return "misdatos";
		
	}
	*/
	/*
	@PostMapping("/newTarjeta")
	public String newTarjeta(Model model, Tarjeta tarjeta, RedirectAttributes ratt) {	
		
		tarjeta.setNombreTitular(tarjeta.getNombreTitular());
		tarjeta.setNumTarjeta(tarjeta.getNumTarjeta());
		tarjeta.setFechaCaducidad(tarjeta.getFechaCaducidad());
		tarjeta.setCvv(tarjeta.getCvv());
		
		//TODO asignar al usuario
	 	
	 	//TODO Revisar con los JSP
	 	
	 	if (tdao.registro(tarjeta)) {
	 		ratt.addFlashAttribute("mensaje", "alta realizada");
	 		return "redirect:/misdatos";
	 	}
	 	else {
	 		model.addAttribute("mensaje", "ya existe la tarjeta");
	 		return "/misdatos";
	 		
	 	}
		
	}
	*/
	/*
	@PostMapping("/newDirection")
	public String proregistrar(Model model, Direccione direccion, RedirectAttributes ratt) {
		
		direccion.setCalle(direccion.getCalle());
		direccion.setCodigoPostal(direccion.getCodigoPostal());
		direccion.setLetra(direccion.getLetra());
		direccion.setLocalidad(direccion.getLocalidad());
		direccion.setNumero(direccion.getNumero());
		direccion.setPiso(direccion.getPiso());
		// TODO asignar el usuario
		
	 	//TODO Revisar con los JSP
	 	
	 	if (ddao.registro(direccion)) {
	 		ratt.addFlashAttribute("mensaje", "alta realizada");
	 		return "redirect:/login";
	 	}
	 	else {
	 		model.addAttribute("mensaje", "ya existe como usuario");
	 		return "/inicioSesion";
	 		
	 	}
		
	}
	*/

}
