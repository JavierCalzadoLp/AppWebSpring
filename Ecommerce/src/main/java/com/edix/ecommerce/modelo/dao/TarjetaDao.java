package com.edix.ecommerce.modelo.dao;

import com.edix.ecommerce.modelo.beans.Tarjeta;
import com.edix.ecommerce.modelo.beans.Usuario;

public interface TarjetaDao {
	
	boolean registro(Tarjeta tarjeta);
	public Tarjeta findById(String numTarjeta);

}
