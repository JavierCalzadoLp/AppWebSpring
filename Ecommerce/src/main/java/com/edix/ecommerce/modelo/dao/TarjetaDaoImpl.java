package com.edix.ecommerce.modelo.dao;

import java.util.List;

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
	public List<Tarjeta> verTodas() {
		
		return trepo.findAll();
	}

	@Override
	public Tarjeta verTarjeta(int idTarjeta) {
		
		return trepo.findById(idTarjeta).orElse(null);
	}

	@Override
	public int altaTarjeta(Tarjeta tarjeta) {
		int filas=0;
		try {
			trepo.save(tarjeta);
			filas=1;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return filas;
	}

	@Override
	public int eliminarTarjeta(int idTarjeta) {
		int filas=0;
		try {
			trepo.deleteById(idTarjeta);
			filas=1;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return filas;
	}

	@Override
	public int modificarTarjeta(Tarjeta tarjeta) {
		int filas=0;
		if(verTarjeta(tarjeta.getIdTarjeta()) != null) {
			trepo.save(tarjeta);
			filas=1;
		}
		
		return filas;
	}

	
}
