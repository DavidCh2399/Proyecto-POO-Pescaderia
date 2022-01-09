package edu.unah.poo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "facturaventa")
public class FacturaVenta {
	@Id
	private int idFacturaVenta;
	private int idEmpleado;
	private int idCliente;
	private String fecha;
	private String lugarVenta;
	
	@ManyToOne
	@JoinColumn(name = "idempleado")
	@JsonBackReference
	private Empleado empleado;
	
	@ManyToOne
	@JoinColumn(name = "idcliente")
	@JsonBackReference
	private Cliente cliente;
	
	public FacturaVenta() {}
	
	public FacturaVenta(int idFacturaVenta, Empleado empleado, Cliente cliente, String fecha, String lugarVenta) {
		super();
		this.idFacturaVenta = idFacturaVenta;
		this.empleado = empleado;
		this.cliente = cliente;
		this.fecha = fecha;
		this.lugarVenta = lugarVenta;
	}

	public int getIdFacturaVenta() {
		return idFacturaVenta;
	}

	public void setIdFacturaVenta(int idFacturaVenta) {
		this.idFacturaVenta = idFacturaVenta;
	}

	public int getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getLugarVenta() {
		return lugarVenta;
	}

	public void setLugarVenta(String lugarVenta) {
		this.lugarVenta = lugarVenta;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}




	
	
}
