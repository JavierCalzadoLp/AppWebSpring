package com.edix.ecommerce.modelo.beans;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

	@Entity
	@Table(name = "USUARIOS_DIRECCIONES")
	public class UsuarioDireccione implements Serializable{

		private static final long serialVersionUID = 1L;

		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "ID")
	    private Long id;
	    
	    @ManyToOne
	    @JoinColumn(name = "ID_USUARIO")
	    private Usuario usuario;
	    
	    @ManyToOne
	    @JoinColumn(name = "ID_DIRECCION")
	    private Direccione direccion;
	    
	    public UsuarioDireccione() {
	    	
	    }

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Usuario getUsuario() {
			return usuario;
		}

		public void setUsuario(Usuario usuario) {
			this.usuario = usuario;
		}

		public Direccione getDireccion() {
			return direccion;
		}

		public void setDireccion(Direccione direccion) {
			this.direccion = direccion;
		}

		@Override
		public String toString() {
			return "UsuarioDireccione [id=" + id + ", usuario=" + usuario + ", direccion=" + direccion + "]";
		}

		@Override
		public int hashCode() {
			return Objects.hash(id);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (!(obj instanceof UsuarioDireccione))
				return false;
			UsuarioDireccione other = (UsuarioDireccione) obj;
			return Objects.equals(id, other.id);
		}
	    
	    
	}



