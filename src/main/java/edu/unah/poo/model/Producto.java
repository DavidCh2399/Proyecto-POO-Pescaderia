package edu.unah.poo.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="producto")

public class Producto {
	
	@Id
	private int idProducto;
	
	private double peso;
	private double precio;
	private String descripcion;
	private LocalDate fecha;
	private int cantidadLatas; 
	
	@ManyToOne
	@JoinColumn(name="idpescado")
	@JsonBackReference
	private Pescado pescado;
	
	@ManyToOne
	@JoinColumn(name="idlote")
	@JsonBackReference
	private Lote lote;
	
	public Producto() {}
	
	public Producto(int idProducto, double peso, double precio, String descripcion, LocalDate fecha, int cantidadLatas, Pescado pescado, Lote lote) {
		super();
		this.idProducto = idProducto;
		this.peso = peso;
		this.precio = precio;
		this.descripcion = descripcion;
		this.fecha = fecha;
		this.cantidadLatas = cantidadLatas;
		this.pescado = pescado;
		this.lote = lote;
	}

	public int getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public int getCantidadLatas() {
		return cantidadLatas;
	}
	public void setCantidadLatas(int cantidadLatas) {
		this.cantidadLatas = cantidadLatas;
	}
	public Pescado getPescado() {
		return pescado;
	}
	public void setPescado(Pescado pescado) {
		this.pescado = pescado;
	}
	public Lote getLote() {
		return lote;
	}
	public void setLote(Lote lote) {
		this.lote = lote;
	}
	

	
	
	
	
}
