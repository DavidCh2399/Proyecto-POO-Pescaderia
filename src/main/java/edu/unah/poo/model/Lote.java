package edu.unah.poo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "lote")
public class Lote {
	@Id
	private int idLote;
	private String estado;
	private int calidad;
	private double peso;
	private double precio;
	
	@ManyToOne
	@JoinColumn(name="idempleado")
	@JsonBackReference
	private Empleado empleado;
	
	@ManyToOne
	@JoinColumn(name="idlimpieza")
	@JsonBackReference
	private Limpieza limpieza;
	
	@ManyToOne
	@JoinColumn(name="idpescado")
	@JsonBackReference
	private Pescado pescado;
	
	@ManyToOne
	@JoinColumn(name="idproveedor")
	@JsonBackReference
	private Proveedor proveedor;
	
	public Lote() {}
	
	public Lote(int idLote, String estado, int calidad, double peso, double precio, Empleado empleado, Limpieza limpieza, Pescado pescado,
			Proveedor proveedor) {
		super();
		this.idLote = idLote;
		this.estado = estado;
		this.calidad = calidad;
		this.peso = peso;
		this.precio = precio;
		this.empleado = empleado;
		this.limpieza = limpieza;
		this.pescado = pescado;
		this.proveedor = proveedor;
	}

	public int getIdLote() {
		return idLote;
	}
	public void setIdLote(int idLote) {
		this.idLote = idLote;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public int getCalidad() {
		return calidad;
	}
	public void setCalidad(int calidad) {
		this.calidad = calidad;
	}
	public Empleado getEmpleado() {
		return empleado;
	}
	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	public Limpieza getLimpieza() {
		return limpieza;
	}
	public void setLimpieza(Limpieza limpieza) {
		this.limpieza = limpieza;
	}
	public Pescado getPescado() {
		return pescado;
	}
	public void setPescado(Pescado pescado) {
		this.pescado = pescado;
	}
	public Proveedor getProveedor() {
		return proveedor;
	}
	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
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


	

}
