package com.edix.ecommerce.modelo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edix.ecommerce.modelo.beans.Direccione;
import com.edix.ecommerce.modelo.beans.Tarjeta;
import com.edix.ecommerce.modelo.beans.UsuarioDireccione;
import com.edix.ecommerce.modelo.repository.DireccioneRepository;
import com.edix.ecommerce.modelo.repository.TarjetaRepository;

@Service
public class DireccioneDaoImpl implements DireccioneDao{
	
	
	@Autowired
	private DireccioneRepository drepo;

	/*
	@Override
	public boolean registro(Direccione direccion) {
		if (findById(direccion.getCalle()) == null) {
				drepo.save(direccion);
				return true;
		}
		return false;
	}
	*/
	/*
	@Override
	public Direccione findById(String direccion) {
		return drepo.findByDireccion(direccion);
	}
	*/

}
