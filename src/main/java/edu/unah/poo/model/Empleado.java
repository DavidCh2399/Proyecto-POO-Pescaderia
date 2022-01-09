package edu.unah.poo.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "empleado")
public class Empleado {
	@Id
	private int idEmpleado;
	private String nombre;
	private String puesto;
	private String direccion;
	private LocalDate fechaContrato;
	private LocalDate fechaNacimiento;
	private int numeroContrato;
	private String pasword;
	
	@OneToMany(mappedBy="empleado", fetch=FetchType.LAZY)
	List<Limpieza> listaLimpiezas = new ArrayList<Limpieza>();

	@OneToMany(mappedBy="empleado", fetch=FetchType.LAZY)
	List<Lote> listaLotes = new ArrayList<Lote>();
	
	@OneToMany(mappedBy="empleado", fetch=FetchType.LAZY)
	List<FacturaVenta> facturas = new ArrayList<FacturaVenta>();
	
	public Empleado() {}
	
	public Empleado(int idEmpleado, String nombre, String puesto, String direccion, LocalDate fechaContrato, LocalDate fechaNacimiento,
			int numeroContrato, String pasword) {
		super();
		this.idEmpleado = idEmpleado;
		this.nombre = nombre;
		this.puesto = puesto;
		this.direccion = direccion;
		this.fechaContrato = fechaContrato;
		this.fechaNacimiento = fechaNacimiento;
		this.numeroContrato = numeroContrato;
		this.pasword = pasword;
	}
	
	public int getIdEmpleado() {
		return idEmpleado;
	}
	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPuesto() {
		return puesto;
	}
	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}
	public LocalDate getFechaContrato() {
		return fechaContrato;
	}
	public void setFechaContrato(LocalDate fechaContrato) {
		this.fechaContrato = fechaContrato;
	}
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public int getNumeroContrato() {
		return numeroContrato;
	}
	public void setNumeroContrato(int numeroContrato) {
		this.numeroContrato = numeroContrato;
	}
	public String getPasword() {
		return pasword;
	}
	public void setPasword(String pasword) {
		this.pasword = pasword;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public List<Limpieza> getListaLimpiezas() {
		return listaLimpiezas;
	}
	public void setListaLimpiezas(List<Limpieza> listaLimpiezas) {
		this.listaLimpiezas = listaLimpiezas;
	}
	public List<Lote> getListaLotes() {
		return listaLotes;
	}
	public void setListaLotes(List<Lote> listaLotes) {
		this.listaLotes = listaLotes;
	}

	public List<FacturaVenta> getFacturas() {
		return facturas;
	}

	public void setFacturas(List<FacturaVenta> facturas) {
		this.facturas = facturas;
	}

	
	

}
