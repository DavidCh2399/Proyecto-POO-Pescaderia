package edu.unah.poo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "proveedor")
public class Proveedor {
	
	@Id
	private int idProveedor;
	private String nombre;
	private String telefono;
	private String pasword;
	
	@OneToMany(mappedBy="proveedor", fetch=FetchType.LAZY)
	List<Lote> listaLotes = new ArrayList<Lote>();
	
	public Proveedor() {}
	
	public Proveedor(int idProveedor, String nombre, String telefono, String pasword) {
		super();
		this.idProveedor = idProveedor;
		this.nombre = nombre;
		this.telefono = telefono;
		this.pasword = pasword;
	}
	public int getIdProveedor() {
		return idProveedor;
	}
	public void setIdProveedor(int idProveedor) {
		this.idProveedor = idProveedor;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
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
	
	

}
