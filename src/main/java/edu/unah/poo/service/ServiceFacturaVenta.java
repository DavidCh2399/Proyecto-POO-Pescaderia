package edu.unah.poo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.unah.poo.model.FacturaVenta;
import edu.unah.poo.repository.RepositoryFacturaVenta;

@Service
public class ServiceFacturaVenta {
	@Autowired
	private RepositoryFacturaVenta repositoryFacturaVenta;
	
	public void crearFacturaVenta(FacturaVenta fv) {
		this.repositoryFacturaVenta.save(fv);
	}
	
	public List<FacturaVenta> listarFacturas(){
		return this.repositoryFacturaVenta.findAll();
	}
	
	public FacturaVenta buscarFactura(int id) {
		return this.repositoryFacturaVenta.findById(id);
	}
	public void eliminarFacturaVenta(FacturaVenta facturaVenta) {
		this.repositoryFacturaVenta.delete(facturaVenta);
	}
	
}
