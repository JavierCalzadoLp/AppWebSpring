package com.edix.ecommerce.modelo.beans;

import java.io.Serializable;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;


/**
 * The persistent class for the usuarios database table.
 * 
 */
@Entity
@Table(name="usuarios")
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_usuario")
	private int idUsuario;

	private String apellidos;

	private String email;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_nacimiento")
	private Date fechaNacimiento;

	private String nombre;

	private String password;
	
	private int enabled;
	
	
	
	//uni-directional many-to-many association to Tarjeta
	@ManyToMany(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(
			name="usuarios_tarjetas"
			, joinColumns= {
					@JoinColumn(name="id_usuario")	
				}
			, inverseJoinColumns = {
					@JoinColumn(name="id_tarjeta")
				}
			)
	private List<Tarjeta> tarjetas;
	
	//uni-directional many-to-many association to Direccione
		@ManyToMany(cascade={CascadeType.PERSIST, CascadeType.MERGE})
		@JoinTable(
				name="usuarios_direcciones"
				, joinColumns= {
						@JoinColumn(name="id_usuario")	
					}
				, inverseJoinColumns = {
						@JoinColumn(name="id_direccion")
					}
				)
		private List<Direccione> direcciones;
		
	
		
	//uni-directional many-to-many association to Role
		@ManyToMany(cascade={CascadeType.PERSIST, CascadeType.MERGE})
		@JoinTable(
				name="usuarios_roles"
				, joinColumns= {
						@JoinColumn(name="id_usuario")	
					}
				, inverseJoinColumns = {
						@JoinColumn(name="id_rol")
					}
				)
		private List<Role> roles;



		public int getIdUsuario() {
			return idUsuario;
		}

		public void setIdUsuario(int idUsuario) {
			this.idUsuario = idUsuario;
		}



		public String getApellidos() {
			return apellidos;
		}

		public void setApellidos(String apellidos) {
			this.apellidos = apellidos;
		}



		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}



		public Date getFechaNacimiento() {
			return fechaNacimiento;
		}

		public void setFechaNacimiento(Date fechaNacimiento) {
			this.fechaNacimiento = fechaNacimiento;
		}



		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}



		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}



		public int getEnabled() {
			return enabled;
		}

		public void setEnabled(int enabled) {
			this.enabled = enabled;
		}



		public List<Tarjeta> getTarjetas() {
			return tarjetas;
		}

		public void setTarjetas(List<Tarjeta> tarjetas) {
			this.tarjetas = tarjetas;
		}



		public List<Direccione> getDirecciones() {
			return direcciones;
		}

		public void setDirecciones(List<Direccione> direcciones) {
			this.direcciones = direcciones;
		}



		public List<Role> getRoles() {
			return roles;
		}

		public void setRoles(List<Role> roles) {
			this.roles = roles;
		}
		
		public void addTarjeta(Tarjeta tarjeta) {
			if (tarjetas == null)
				tarjetas = new ArrayList<>();
			tarjetas.add(tarjeta);
		}
		
		public void removeTarjeta(Tarjeta tarjeta) {
			if (tarjetas == null)
				tarjetas = new ArrayList<>();
			tarjetas.remove(tarjeta);
		}
		
		public void addDireccion(Direccione direccion) {
			if (direcciones == null)
				direcciones = new ArrayList<>();
			direcciones.add(direccion);
		}
	
		public void removeDireccion(Direccione direccion) {
			if (direcciones == null)
				direcciones = new ArrayList<>();
			direcciones.remove(direccion);
		}
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((email == null) ? 0 : email.hashCode());
			return result;
		}
		
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (!(obj instanceof Usuario))
				return false;
			Usuario other = (Usuario) obj;
			if (email == null) {
				if (other.email != null)
					return false;
			} else if (!email.equals(other.email))
				return false;
			return true;
		}
		
		
	
	
	
	

}