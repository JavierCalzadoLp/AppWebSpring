package com.edix.ecommerce.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.edix.ecommerce.modelo.beans.Producto;
import com.edix.ecommerce.modelo.beans.Usuario;
import com.edix.ecommerce.modelo.repository.ProductoRepository;
import com.edix.ecommerce.modelo.repository.UsuarioRepository;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/rest")
public class EcommerceRestController {
	
	@GetMapping("/pruebas")
	public String haciendoPruebas() {
		
		return "Estamos haciendo pruebas - debería funcionar";
	}
	
	//Precio de un producto solicitado
	
	@Autowired
    private ProductoRepository productoRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;

    @GetMapping("/producto/{id}/precio")
    public @ResponseBody Double damePrecioById(@PathVariable("id") double id) { 
        Producto producto = productoRepository.findById((int) id).orElse(null);
        if (producto != null) {
            return (double) producto.getPrecio();
        }
        return null;
    }
	
	
	//Listado de productos de un modelo de zapatillas en exclusiva (Hay que indicar el modelo de zapatillas)
    
    @GetMapping("/todos")
    public List<Producto> obtenerTodosProductos(){
    	
    	return productoRepository.findAll();
    }
    
    @GetMapping("/porNombre/{nombre}")
    public List<Producto> obtenerProductoPorNombre(@PathVariable("nombre") String nombre){
    	
    	return productoRepository.buscarPorNombre(nombre);
    }
	
	
	//Listado de cuantos clientes de cada provincia tenemos en nuestra DB de clientes (usuarios)
    
    @GetMapping("/porCiudad/{localidad}")
    public List<Usuario> obtenerUsuariosPorLocalidad(@PathVariable("localidad") String localidad){
    	
    	return usuarioRepository.buscarPorCiudad(localidad);
    }
	
	

}
