package com.grupoasd.pojo;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonBackReference;

/**
 * Clase de Dominio ActivoFijo
 * @author Diego
 * @since 21-02-2017
 */
@Entity
@Table(name = "ActivoFijo")
public class ActivoFijo {

	@Id
	@GeneratedValue
	private int codigo;
	private String nombre;
	private String descripcion;
	private String serial;
	private String numeroInternoInventario;
	private Double peso;
	private Double alto;
	private Double ancho;
	private Double largo;
	private Double valorCompra;
	private Date fechaCompra;
	private Date fechaBaja;
	private int codigoEstadoActual;
	
	/*
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonBackReference
	@JoinColumn(name="codigoEstadoActual")
	private EstadoActivoFijo codigoEstadoActual;*/
	
	private int codigoTipoActivo;
	private int codigoArea;
	private String color;

	public ActivoFijo() {
		
	}
	
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
	
	public String getSerial() {
		return serial;
	}
	public void setSerial(String serial) {
		this.serial = serial;
	}
	public String getNumeroInternoInventario() {
		return numeroInternoInventario;
	}
	public void setNumeroInternoInventario(String numeroInternoInventario) {
		this.numeroInternoInventario = numeroInternoInventario;
	}
	public Double getPeso() {
		return peso;
	}
	public void setPeso(Double peso) {
		this.peso = peso;
	}
	public Double getAlto() {
		return alto;
	}
	public void setAlto(Double alto) {
		this.alto = alto;
	}
	public Double getAncho() {
		return ancho;
	}
	public void setAncho(Double ancho) {
		this.ancho = ancho;
	}
	public Double getLargo() {
		return largo;
	}
	public void setLargo(Double largo) {
		this.largo = largo;
	}
	public Double getValorCompra() {
		return valorCompra;
	}
	public void setValorCompra(Double valorCompra) {
		this.valorCompra = valorCompra;
	}
	public Date getFechaCompra() {
		return fechaCompra;
	}
	public void setFechaCompra(Date fechaCompra) {
		this.fechaCompra = fechaCompra;
	}
	public Date getFechaBaja() {
		return fechaBaja;
	}
	public void setFechaBaja(Date fechaBaja) {
		this.fechaBaja = fechaBaja;
	}
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	public int getCodigoEstadoActual() {
		return codigoEstadoActual;
	}
	public void setCodigoEstadoActual(int codigoEstadoActual) {
		this.codigoEstadoActual = codigoEstadoActual;
	}
	
	public int getCoditoTipoActivo() {
		return codigoTipoActivo;
	}
	public void setCoditoTipoActivo(int codigoTipoActivo) {
		this.codigoTipoActivo = codigoTipoActivo;
	}
	public int getCodigoArea() {
		return codigoArea;
	}
	public void setCodigoArea(int codigoArea) {
		this.codigoArea = codigoArea;
	}
	@Override
	public String toString() {
		return "ActivoFijo [codigo=" + codigo + ", nombre=" + nombre
				+ ", descripcion=" + descripcion + ", serial=" + serial
				+ ", numeroInternoInventario=" + numeroInternoInventario
				+ ", peso=" + peso + ", alto=" + alto + ", ancho=" + ancho
				+ ", largo=" + largo + ", valorCompra=" + valorCompra
				+ ", fechaCompra=" + fechaCompra + ", fechaBaja=" + fechaBaja
				+ ", codigoEstadoActual=" + codigoEstadoActual
				+ ", coditoTipoActivo=" + codigoTipoActivo + ", codigoArea="
				+ codigoArea + ", color=" + color + "]";
	}
	
}
