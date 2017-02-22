package com.grupoasd.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EstadoActivoFijo")
public class EstadoActivoFijo {
	
	@Id
	@GeneratedValue
	private int codigo;
	
	private String nombre;
	private String descripcion;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	@Override
	public String toString() {
		return "EstadoActivoFijo [codigo=" + codigo + ", nombre=" + nombre
				+ ", descripcion=" + descripcion + "]";
	}
	
}
