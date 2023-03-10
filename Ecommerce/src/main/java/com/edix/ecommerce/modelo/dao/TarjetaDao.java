package com.edix.ecommerce.modelo.dao;

import java.util.List;

import com.edix.ecommerce.modelo.beans.Tarjeta;
import com.edix.ecommerce.modelo.beans.Usuario;

public interface TarjetaDao {
	
	
	List<Tarjeta> verTodas();
	
	Tarjeta verTarjeta(int idTarjeta);
	
	int altaTarjeta(Tarjeta tarjeta);
	int eliminarTarjeta(int idTarjeta);
	int modificarTarjeta(Tarjeta tarjeta);
}
