package edu.unah.poo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.unah.poo.model.Proveedor;
import edu.unah.poo.repository.RepositoryProveedor;

@Service
public class ServiceProveedor {
	@Autowired
	RepositoryProveedor repositoryProveedor;
	
	public void crearProveedor(Proveedor p) {
		this.repositoryProveedor.save(p);
	}
	
	public Proveedor buscarProveedor(int id) {
		return this.repositoryProveedor.findById(id);
	}
	
	public List<Proveedor> listarProveedores(){
		return this.repositoryProveedor.findAll();
	}
}
