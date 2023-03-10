package com.edix.ecommerce.controller;

import java.security.Timestamp;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.edix.ecommerce.modelo.beans.Producto;
import com.edix.ecommerce.modelo.beans.Role;
import com.edix.ecommerce.modelo.beans.Usuario;
import com.edix.ecommerce.modelo.dao.CarritoDao;
import com.edix.ecommerce.modelo.dao.ProductoDaoImpl;
import com.edix.ecommerce.modelo.dao.RoleDaoImpl;
import com.edix.ecommerce.modelo.dao.UsuarioDao;
import com.edix.ecommerce.modelo.repository.UsuarioRepository;
import com.edix.ecommerce.utils.CarritoUtils;

import javax.servlet.http.HttpSession;


//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.core.Authentication;


@Controller
public class HomeController {
	@Autowired
	ProductoDaoImpl pdao;
	@Autowired
	RoleDaoImpl rdao;
	@Autowired
	UsuarioDao udao;
	
	@Autowired
	UsuarioRepository urepo;
	
	@Autowired
	CarritoUtils utils;
	@Autowired
	CarritoDao cdao;
	
	//private   PasswordEncoder pwcript;
	
	/*
    public HomeController(PasswordEncoder pwcript) {
        this.pwcript = pwcript;
    }
	*/
	@GetMapping("/")
	public String Saludo() {
		
		return "inicio";
	}
	/*
	
	@GetMapping("/encriptar/{pass}")
    @ResponseBody
    public String encriptar(@PathVariable("pass") String pass) {
        String newPassw= null;
        newPassw = "El texto es: " + pwcript.encode(pass);
        return newPassw;
    }
    */

	@GetMapping("/user/logout")
    public String logout(Model model, HttpSession misesion) {
        Map<Producto, Integer> carrito = utils.crearComprobarCarrito(misesion, model);
        Usuario user = (Usuario) misesion.getAttribute("sesion");

        cdao.saveCarrito(carrito, user);
        misesion.removeAttribute("sesion");

        return "redirect:/logout";

    }
/*
	
	@GetMapping("/inicio")
    public String procesarLogin(Authentication aut, Model model, HttpSession misesion) {
        Usuario usuario = udao.buscarPorEmail(aut.getUsername());

        if (misesion.getAttribute("sesion") == null)
            misesion.setAttribute("sesion", usuario);

        System.out.println("Nombre : " + aut.getUsername());
        //for (GrantedAuthority ele: aut.getClass())
            //System.out.println("Roles : " + ele.getAuthority());

        
        utils.crearComprobarCarrito(misesion, model);
        Map<Producto, Integer> carrito = new HashMap<>();
        carrito = cdao.recuperarCarrito(usuario.getIdUsuario());

        misesion.setAttribute("carrito",carrito);
        model.addAttribute("carrito", carrito);

        return "redirect:/";
    }
	*/
	/*
	@GetMapping("/registrado")
    public String procesarLogin(Authentication aut, Model model, HttpSession misesion) {
        Usuario usuario = udao.buscarPorEmail(aut.getUsername());
        System.out.println("LOGIN ID ====== "+usuario.getIdUsuario());
        misesion.setAttribute("IDusuario", usuario.getIdUsuario());
        return "/index";
    }
	*/
	
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
	
	/*
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
	*/
	@PostMapping("/registro")
	public String registrarUsuario(Model model,RedirectAttributes ratt,Usuario usuario, @RequestParam("nombre") String nombre ,
												@RequestParam("apellidos")String apellidos,
												@RequestParam("email")String email, 
												@RequestParam("fechaNacimiento") Date fechaNacimiento, 
												@RequestParam("password") String password ){
		
		Role r1 = new Role();
		r1.setIdRol(1);
		

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
	    		ratt.addFlashAttribute("mensaje", "Alta usuario completada");
	        return "redirect:/registro";
	    } else {
	        //ratt.addAttribute("mensaje", "Ha ocurrido un error");
	        ratt.addFlashAttribute("mensaje", "Ha ocurrido un error");
	        return "registro";
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
