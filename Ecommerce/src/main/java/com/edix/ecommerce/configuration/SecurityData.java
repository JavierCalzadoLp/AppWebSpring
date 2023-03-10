/*
package com.edix.ecommerce.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
*/
/*
@EnableWebSecurity
@Configuration
*/
 
 /*
public class SecurityData extends WebSecurityConfigurerAdapter {
	*/
/*
	@Autowired
	private DataSource dataSource;
*/

/*

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{

		auth
			.jdbcAuthentication().dataSource(dataSource)
			.usersByUsernameQuery("SELECT email, password, enabled FROM Usuarios " +
					"WHERE email=?")
		
			.authoritiesByUsernameQuery("SELECT u.email, r.nombre FROM Usuarios u "
					+ "INNER JOIN Roles r on r.id_rol = u.id_rol "
					+ "WHERE u.email =?");
	}
	*/

/*
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{

		http
			.csrf().disable() 
			.authorizeRequests() 
				.antMatchers().permitAll() 
				.antMatchers("/"
						,"/inicio"
						,"/logout"
						,"/todosProductos"
						,"/detalleProducto"
						,"/ordenarProductos"
						,"/buscarProductos"
						,"/registro"
						,"/error"
						,"/usuarios/addTarjeta"
						,"/usuarios/addDireccion"
						,"/usuarios/carrito"
						,"/usuarios/anadirUno/{idProducto}"
						,"/usuarios/eliminar/{idProducto}"
						,"/usuarios/guardar"
						,"usuarios/comprar"
						,"/usuarios/pagar"
						,"admin/verUsuarios"
						,"admin/altaProducto"
						,"admin/{idUsuario}"
						,"admin/eliminarProducto"
						,"admin/eliminarProducto/{idProducto}"
						,"admin/editar/{id}"
						,"admin/modificar"
						,"admin/editarRole/{id}"
						,"admin/modificarRole"
						,"admin/pedidos"
						,"/admin/ordenarPedidos"
						,"/admin/detallesPedidos/{idPedido}"
						,"/admin/registro"
						,"/images/**"
						).permitAll()
				
				
				//.antMatchers("/encriptar/**").permitAll()
				//.anyRequest().authenticated() /*Cualquier otra petición necesita registro*/
				//.and()
				//.formLogin()
				//		.defaultSuccessUrl("/inicio", true)
				//		//Si el Login es Correcto, nos lleva a /inicio que procesa el login manualmente
				//.permitAll();
	//}

	/*
	Para encriptar la contraseña antes de guardarla en la base de datos
	y para poder comparar con la que nos pasen
	 */
/*
	@Bean
	public PasswordEncoder passwordEncorder (){

		return new BCryptPasswordEncoder();
	}
}
*/
