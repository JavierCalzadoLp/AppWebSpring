package com.edix.ecommerce.modelo.beans;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
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

	//uni-directional many-to-one association to Direccione
	@ManyToOne
	@JoinColumn(name="id_direccion")
	private Direccione direccione;

	//uni-directional many-to-one association to Tarjeta
	@ManyToOne
	@JoinColumn(name="id_tarjeta")
	private Tarjeta tarjeta;

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

	@Override
	public String toString() {
		return "Pedido [idPedido=" + idPedido + ", fecha=" + fecha + ", direccione=" + direccione + ", tarjeta="
				+ tarjeta + "]";
	}

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
	
	

}