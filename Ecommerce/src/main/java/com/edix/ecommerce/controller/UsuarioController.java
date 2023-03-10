package com.edix.ecommerce.controller;

import java.util.Date;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.edix.ecommerce.modelo.beans.Direccione;
import com.edix.ecommerce.modelo.beans.Pedido;
import com.edix.ecommerce.modelo.beans.Producto;
import com.edix.ecommerce.modelo.beans.Tarjeta;
import com.edix.ecommerce.modelo.beans.Usuario;
import com.edix.ecommerce.modelo.beans.UsuarioDireccione;
import com.edix.ecommerce.modelo.dao.CarritoDao;
import com.edix.ecommerce.modelo.dao.DireccioneDao;
import com.edix.ecommerce.modelo.dao.PedidoDao;
import com.edix.ecommerce.modelo.dao.ProductoDaoImpl;
import com.edix.ecommerce.modelo.dao.RoleDaoImpl;
import com.edix.ecommerce.modelo.dao.TarjetaDao;
import com.edix.ecommerce.modelo.dao.UsuarioDao;
import com.edix.ecommerce.modelo.repository.PedidoRepository;
import com.edix.ecommerce.modelo.repository.ProductoRepository;
import com.edix.ecommerce.utils.CarritoUtils;

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
	
	@Autowired
    CarritoUtils utils;
    @Autowired
    CarritoDao cdao;
    @Autowired
    PedidoRepository prepo;
    @Autowired
    ProductoRepository prorepo;
	@Autowired
	PedidoDao pedao;
	

	
	@GetMapping("/addTarjeta")
	public String addTarjeta(Model model) {
		
		
		return "addTarjeta";
	}
	
	
	
	@PostMapping("/addTarjeta")
	public String newTarjeta(Model model, Tarjeta tarjeta, RedirectAttributes ratt) {	
		
		tarjeta.setNombreTitular(tarjeta.getNombreTitular());
		tarjeta.setNumTarjeta(tarjeta.getNumTarjeta());
		tarjeta.setFechaCaducidad(tarjeta.getFechaCaducidad());
		tarjeta.setCvv(tarjeta.getCvv());
		
	 	
	 	if (tdao.altaTarjeta(tarjeta) != 0) {
	 		ratt.addFlashAttribute("mensaje", "alta realizada");
	 		return "redirect:/usuarios/addTarjeta";
	 	}
	 	else {
	 		model.addAttribute("mensaje", "ya existe la tarjeta");
	 		return "/usuarios/addTarjeta";
	 		
	 	}
		
	}
	
	
	@GetMapping("/addDireccion")
	public String addDireccion(Model model) {
		
		return "addDireccion";
	}
	
	@PostMapping("/addDireccion")
	public String proregistrar(Model model, Direccione direccion, RedirectAttributes ratt) {
		
		direccion.setCalle(direccion.getCalle());
		direccion.setCodigoPostal(direccion.getCodigoPostal());
		direccion.setLetra(direccion.getLetra());
		direccion.setLocalidad(direccion.getLocalidad());
		direccion.setNumero(direccion.getNumero());
		direccion.setPiso(direccion.getPiso());
		// TODO asignar el usuario
		
	 	//TODO Revisar con los JSP
	 	
	 	if (ddao.altaDireccion(direccion) != 0) {
	 		ratt.addFlashAttribute("mensaje", "alta realizada");
	 		return "redirect:/usuarios/addDireccion";
	 	}
	 	else {
	 		model.addAttribute("mensaje", "ya existe como dirección");
	 		return "/usuarios/addDireccion";
	 		
	 	}
		
	}
	
	//Endpoint para comprobar si hay un carrito y devolverlo en el caso que lo haya
		@GetMapping("/carrito")
		public String verProductosCarrito(Model model, HttpSession misesion) {
			//Comprobamos si hay un carrito en la sesión
			utils.crearComprobarCarrito(misesion, model);
			return "carrito";
		}
		
		
		//Trae el carrito y añade el nuevo producto a este
		@GetMapping("/anadirUno/{idProducto}")
		public String añadirUno(Model model,@PathVariable int idProducto,HttpSession misesion) {

			Map<Producto, Integer> carrito = utils.crearComprobarCarrito(misesion, model);
			cdao.addProductoCarrito(carrito, idProducto);
			
			return "redirect:/usuarios/carrito";
		}
		
		//Recpera carrito y elimina si se necesita
		@GetMapping("/eliminarUno/{idProducto}")
		public String eliminarUno(Model model,@PathVariable int idProducto,HttpSession misesion) {

			Map<Producto, Integer> carrito = utils.crearComprobarCarrito(misesion, model);
			cdao.eliminateProductoCarrito(carrito, idProducto);
			
			return "redirect:/usuarios/carrito";
		}

		//Guardar el carrito
		@GetMapping("/guardar")
		public String guardarCarrito(Model model, HttpSession misesion) {
			
			Map<Producto, Integer> carrito = utils.crearComprobarCarrito(misesion, model);
			//Usuario user = (Usuario) misesion.getAttribute("sesion");
			Usuario user = udao.verUsuario(2);
			cdao.saveCarrito(carrito, user);
			
			return "redirect:/usuarios/carrito";
		}

		//Compra del pedido
		@GetMapping("/comprar")
		public String mostrarCompra(Model model, HttpSession misesion) {
			Map<Producto, Integer> carrito = utils.crearComprobarCarrito(misesion, model);
			//Usuario user = (Usuario) misesion.getAttribute("sesion");
			Usuario user = udao.verUsuario(2);
			
			model.addAttribute("carrito", carrito);
			model.addAttribute("user", udao.verUsuario(user.getIdUsuario()));

			return "procesarCompra";
		}

		//Pago del pedido
		@PostMapping("/pagar")
		public String pagarCarrito(Model model, HttpSession misesion, @RequestParam("idDireccion") int idDireccion
																	, @RequestParam("idTarjeta") int idTarjeta){

			//Usuario user = (Usuario) misesion.getAttribute("sesion");
			Usuario user = udao.verUsuario(2);
			Pedido pedido = prepo.mostrarPedidoCarritoPorCliente(user.getIdUsuario());

			Direccione dir = ddao.verDireccione(idDireccion);
			Tarjeta tar = tdao.verTarjeta(idTarjeta);

			if(pedido.getEstado().equals("CARRITO")) {
				pedido.setEstado("COMPLETADO");
				pedido.setDireccione(dir);
				pedido.setTarjeta(tar);
				prepo.save(pedido);
				pedao.byeStock(pedido);
				
				misesion.removeAttribute("carrito");
			}else {
				model.addAttribute("error", "No se ha podido realizar el pago");
				return "redirect:/procesarCompra";
			}
			return "compraCompletada";
		}
	
		@GetMapping("/compraCompletada")
		public String compraCompletada() {
			
			return "compraCompletada";
		}

}
