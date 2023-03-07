package com.edix.ecommerce.modelo.dao;

import java.util.List;

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

	@Override
	public List<Direccione> verTodas() {
		
		return drepo.findAll();
	}

	@Override
	public Direccione verDireccione(int idDireccion) {
		
		return drepo.findById(idDireccion).orElse(null);
	}

	@Override
	public int altaDireccion(Direccione direccione) {
		int filas=0;
		try {
			drepo.save(direccione);
			filas=1;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return filas;
	}

	@Override
	public int eliminarDireccion(int idDireccion) {
		int filas=0;
		try {
			drepo.deleteById(idDireccion);
			filas=1;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return filas;
	}

	@Override
	public int modificarDireccion(Direccione direccione) {
		int filas=0;
		if(verDireccione(direccione.getIdDireccion()) != null) {
			drepo.save(direccione);
			filas=1;
		}
		return filas;
	}

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
