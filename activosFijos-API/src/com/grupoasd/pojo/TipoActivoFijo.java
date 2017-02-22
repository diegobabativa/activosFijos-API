package com.grupoasd.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="TipoActivoFijo")
public class TipoActivoFijo {
	
	@Id
	@GeneratedValue
	private int codigo;
	
	private String nombre;

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

	@Override
	public String toString() {
		return "TipoActivoFijo [codigo=" + codigo + ", nombre=" + nombre + "]";
	}
	
	

}
