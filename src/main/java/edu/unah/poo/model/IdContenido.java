package edu.unah.poo.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Embeddable
public class IdContenido implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idProducto;
	private int idVenta;
	
	public IdContenido() {}
	
	public IdContenido(int idProducto, int idVenta) {
		super();
		this.idProducto = idProducto;
		this.idVenta = idVenta;
	}
	
	public int getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}
	public int getIdVenta() {
		return idVenta;
	}
	public void setIdVenta(int idVenta) {
		this.idVenta = idVenta;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof IdContenido) {
			IdContenido tmpid = (IdContenido)obj;
			if(this.idProducto == tmpid.getIdProducto() && this.idVenta == tmpid.getIdVenta()) {
				return true;
			}else 
				return false;
		}else 
			return false;
	}
	
	public int hashCode() {
		return (int) this.idProducto + this.idVenta;
	}
	
	
	

}
