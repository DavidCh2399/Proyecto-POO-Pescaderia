package edu.unah.poo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.unah.poo.model.Producto;
import edu.unah.poo.repository.RepositoryProducto;

@Service
public class ServiceProducto {
	@Autowired
	private RepositoryProducto repositoryProducto;
	
	public void crearProducto(Producto p) {
		this.repositoryProducto.save(p);
	}
	
	public List<Producto> listarProductos(){
		return this.repositoryProducto.findAll();
	}
	
	public Producto obtenerProducto(int id) {
		return this.repositoryProducto.findById(id);
	}
	
	public void actualizarCantidadExistente(int cantidadExistente, int idProducto) {
		this.repositoryProducto.actualizarcantidadExistente(cantidadExistente, idProducto);;
	}
	
}
