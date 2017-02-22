package com.grupoasd.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.Table;


@Entity
@Table(name = "Area")
public class Area {
	

	@Id
	@GeneratedValue
	private int codigo;
	private String nombre;
	private int codigoCiudad;

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

	public int getCodigoCiudad() {
		return codigoCiudad;
	}

	public void setCodigoCiudad(int codigoCiudad) {
		this.codigoCiudad = codigoCiudad;
	}

	@Override
	public String toString() {
		return "Area [codigo=" + codigo + ", nombre=" + nombre
				+ ", codigoCiudad=" + codigoCiudad + "]";
	}
	
	}
