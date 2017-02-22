package com.grupoasd.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "activofijo")
public class ActivoFijo {

	@Id
	@GeneratedValue
	private int codigo;
	
	private String nombre;
	private String descripcion;
	
	

}
