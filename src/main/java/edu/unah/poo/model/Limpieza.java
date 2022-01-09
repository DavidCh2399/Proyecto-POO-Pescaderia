package edu.unah.poo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "limpieza")
public class Limpieza {
	@Id
	private int idLimpieza;
	private String horaInicio;
	private String horaFinal;
	private int cantidadEmpleados;
	
	@ManyToOne
	@JoinColumn(name="idEmpleado")
	@JsonBackReference
	private Empleado empleado;
	
	@OneToMany(mappedBy="limpieza", fetch=FetchType.LAZY)
	List<Lote> listaLotes = new ArrayList<Lote>();
	
	public Limpieza() {}

	public Limpieza(int idLimpieza, String horaInicio, String horaFinal, int cantidadEmpleados, Empleado empleado) {
		super();
		this.idLimpieza = idLimpieza;
		this.horaInicio = horaInicio;
		this.horaFinal = horaFinal;
		this.cantidadEmpleados = cantidadEmpleados;
		this.empleado = empleado;
	}

	public int getIdLimpieza() {
		return idLimpieza;
	}
	public void setIdLimpieza(int idLimpieza) {
		this.idLimpieza = idLimpieza;
	}
	public String getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}
	public String getHoraFinal() {
		return horaFinal;
	}
	public void setHoraFinal(String horaFinal) {
		this.horaFinal = horaFinal;
	}
	public List<Lote> getListaLotes() {
		return listaLotes;
	}
	public void setListaLotes(List<Lote> listaLotes) {
		this.listaLotes = listaLotes;
	}
	public int getCantidadEmpleados() {
		return cantidadEmpleados;
	}
	public void setCantidadEmpleados(int cantidadEmpleados) {
		this.cantidadEmpleados = cantidadEmpleados;
	}
	public Empleado getEmpleado() {
		return empleado;
	}
	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	
	
	

	
	

}
