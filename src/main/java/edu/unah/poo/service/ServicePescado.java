package edu.unah.poo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.unah.poo.model.Pescado;
import edu.unah.poo.repository.RepositoryPescado;

@Service
public class ServicePescado {
	@Autowired
	private RepositoryPescado repositoryPescado;
	
	public void crearPescado(Pescado p) {
		this.repositoryPescado.save(p);
	}
	
	public List<Pescado> listarPescados(){
		return this.repositoryPescado.findAll();
	}
	
	public Pescado buscarPescado(int id) {
		return this.repositoryPescado.findById(id);
	}
}
