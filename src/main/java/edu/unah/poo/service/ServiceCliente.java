package edu.unah.poo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.unah.poo.model.Cliente;
import edu.unah.poo.repository.RepositoryCliente;

@Service
public class ServiceCliente {
	@Autowired
	RepositoryCliente repositoryCliente;
	
	public void crearCliente(Cliente c) {
		this.repositoryCliente.save(c);
	}
	
	public List<Cliente> listarClientes(){
		return this.repositoryCliente.findAll();
	}
	
	public Cliente buscarCliente(int id) {
		return this.repositoryCliente.findById(id);
	}
	
}
