package edu.unah.poo.model;

//import java.util.ArrayList;
//import java.util.List;

import javax.persistence.Entity;
//import javax.persistence.FetchType;
import javax.persistence.Id;
//import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente {
	
	@Id
	private int idCliente;
	private String nombre;
	private String direccion;
	private String telefono;
	private String pasword;
	
	/*@OneToMany(mappedBy="cliente", fetch=FetchType.LAZY)
	private List<FacturaVenta> compras = new ArrayList<FacturaVenta>();
	*/
	public Cliente() {}
	
	public Cliente(int idCliente, String nombre, String direccion, String telefono, String pasword) {
		super();
		this.idCliente = idCliente;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.pasword = pasword;
	}

	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getPasword() {
		return pasword;
	}
	public void setPasword(String pasword) {
		this.pasword = pasword;
	}
	/*public List<FacturaVenta> getCompras() {
		return compras;
	}
	public void setCompras(List<FacturaVenta> compras) {
		this.compras = compras;
	}*/
	




}
