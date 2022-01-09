package edu.unah.poo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "pescado")
public class Pescado {
	@Id
	private int idPescado;
	
	private String tipo;
	private String color;
	private String nombre;
	private double tamanio;
	
	@OneToMany(mappedBy="pescado", fetch=FetchType.LAZY)
	List<Lote> listaLotes = new ArrayList<Lote>();
	
	public Pescado() {}
	
	public Pescado(int idPescado, String tipo, String color, String nombre, double tamanio) {
		super();
		this.idPescado = idPescado;
		this.tipo = tipo;
		this.color = color;
		this.nombre = nombre;
		this.tamanio = tamanio;
	}
	
	public int getIdPescado() {
		return idPescado;
	}
	public void setIdPescado(int idPescado) {
		this.idPescado = idPescado;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getTamanio() {
		return tamanio;
	}
	public void setTamanio(double tamanio) {
		this.tamanio = tamanio;
	}
	
	
	
}
