package edu.unah.poo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.unah.poo.model.Limpieza;
import edu.unah.poo.repository.RepositoryLimpieza;

@Service
public class ServiceLimpieza {
	
	@Autowired
	private RepositoryLimpieza repositoryLimpieza;
	
	public void crearLimpieza(Limpieza l) {
		this.repositoryLimpieza.save(l);
	}
	
	public List<Limpieza> listarLimpiezas(){
		return this.repositoryLimpieza.findAll();
	}
	
	public Limpieza buscarLimpieza(int id) {
		return this.repositoryLimpieza.findById(id);
	}

}
