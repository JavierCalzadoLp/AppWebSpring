package com.edix.ecommerce.modelo.beans;

import java.io.Serializable;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;


/**
 * The persistent class for the pedidos database table.
 * 
 */
@Entity
@Table(name="pedidos")
@NamedQuery(name="Pedido.findAll", query="SELECT p FROM Pedido p")
public class Pedido implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_pedido")
	private int idPedido;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;
	
	private String estado;
	

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	//uni-directional many-to-one association to Direccione
	@ManyToOne
	@JoinColumn(name="id_direccion")
	private Direccione direccione;

	//uni-directional many-to-one association to Tarjeta
	@ManyToOne
	@JoinColumn(name="id_tarjeta")
	private Tarjeta tarjeta;
	
	//uni-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuario usuario;
	
	//bi-directional many-to-one association to PedidosProductos
	@OneToMany(mappedBy="pedido", cascade= {CascadeType.PERSIST})
	private List<PedidosProductos> pedidosproductos;

	public Pedido() {
	}

	public int getIdPedido() {
		return this.idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Direccione getDireccione() {
		return this.direccione;
	}

	public void setDireccione(Direccione direccione) {
		this.direccione = direccione;
	}

	public Tarjeta getTarjeta() {
		return this.tarjeta;
	}

	public void setTarjeta(Tarjeta tarjeta) {
		this.tarjeta = tarjeta;
	}
	

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	public List<PedidosProductos> getPedidosproductos() {
		return pedidosproductos;
	}

	public void setPedidosproductos(List<PedidosProductos> pedidosproductos) {
		this.pedidosproductos = pedidosproductos;
	}
	
	

	public PedidosProductos addPedidosProductos(PedidosProductos pedidosproductos) {
		getPedidosproductos().add(pedidosproductos);
		pedidosproductos.setPedido(this);
		
		return pedidosproductos;
	}
	
	public PedidosProductos removePedidosProductos(PedidosProductos pedidosproductos) {
		getPedidosproductos().add(pedidosproductos);
		pedidosproductos.setPedido(this);
		
		return pedidosproductos;
	}
	
	/*
	 public void addPedidosProductos(List<PedidosProductos> pedidosproductos) {
		if(pedidosproductos == null) {
			pedidosproductos = new ArrayList<>();
			pedidosproductos.addAll(pedidosproductos);
		((PedidosProductos) pedidosproductos).setPedido(this);
		}
	}
	
	public void removePedidosProductos(List<PedidosProductos> pedidosproductos) {
		if(pedidosproductos == null)
			pedidosproductos = new ArrayList<>();
			pedidosproductos.remove(pedidosproductos);
		((PedidosProductos) pedidosproductos).setPedido(this);
		
	}
	
	
	public void removePedidosProductos(List<PedidosProductos> pedidosproductosList) {
	    if (pedidosproductosList != null && !pedidosproductosList.isEmpty()) {
	        for (PedidosProductos pedidosproductos : pedidosproductosList) {
	            pedidosproductos.setPedido(null);
	        }
	        pedidosproductosList.clear();
	    }
	}
*/



	@Override
	public int hashCode() {
		return Objects.hash(idPedido);
	}

	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Pedido))
			return false;
		Pedido other = (Pedido) obj;
		return idPedido == other.idPedido;
	}

	@Override
	public String toString() {
		return "Pedido [idPedido=" + idPedido + ", fecha=" + fecha + ", estado=" + estado + ", direccione=" + direccione
				+ ", tarjeta=" + tarjeta + ", usuario=" + usuario + ", pedidosproductos=" + pedidosproductos + "]";
	}
	
	
	
	

}