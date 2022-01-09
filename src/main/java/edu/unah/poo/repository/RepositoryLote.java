package edu.unah.poo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.unah.poo.model.Lote;

public interface RepositoryLote extends JpaRepository<Lote, Integer>{
	public Lote findById(int id);
}
