package edu.unah.poo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.unah.poo.model.FacturaVenta;

public interface RepositoryFacturaVenta extends JpaRepository<FacturaVenta, Integer>{
	public FacturaVenta findById(int id);
}
