package edu.unah.poo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.unah.poo.model.Lote;
import edu.unah.poo.repository.RepositoryLote;

@Service
public class ServiceLote {
	@Autowired
	private RepositoryLote repositoryLote;
	
	public void crearLote(Lote l) {
		this.repositoryLote.save(l);
	}
	
	public Lote buscarLote(int id) {
		return this.repositoryLote.findById(id);
	}
	
	public List<Lote> listarLotes(){
		return this.repositoryLote.findAll();
	}
}
