package com.edix.ecommerce.modelo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edix.ecommerce.modelo.beans.Tarjeta;
import com.edix.ecommerce.modelo.beans.Usuario;
import com.edix.ecommerce.modelo.repository.TarjetaRepository;
import com.edix.ecommerce.modelo.repository.UsuarioRepository;

@Service
public class TarjetaDaoImpl implements TarjetaDao{
	
	@Autowired
	private TarjetaRepository trepo;

	
	@Override
	public boolean registro(Tarjeta tarjeta) {
		if (findById(tarjeta.getNumTarjeta()) == null) {
				trepo.save(tarjeta);
				return true;
		}
		return false;
	}
	
	@Override
	public Tarjeta findById(String numTarjeta) {
		return trepo.findByNumTarjeta(numTarjeta);
	}
	
}
