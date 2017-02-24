package com.grupoasd.dao;

import java.util.Date;
import java.util.List;

import com.grupoasd.pojo.ActivoFijo;

/**
 * Interface que se encarga de especificar los métodos usados para el Objeto de
 * Acceso a Datos
 * 
 * @author Diego Babativa
 * @since 23-02-2017
 *
 */
public interface ActivoFijoDao {

	/**
	 * Especificación de método encargado de retornar un Activo Fijo buscado por
	 * 
	 * @param id
	 * @return
	 */
	public ActivoFijo findById(int codigo);

	/**
	 * Especificación de método encargado de retornar todos los Activos Fijos
	 * encontrados
	 * 
	 * @return List<ActivoFijo>
	 */
	public List<ActivoFijo> findAll();

	/**
	 * Especificación de método encargado de retornar los Activos Fijos
	 * filtrados por Tipo
	 * 
	 * @param idTipo
	 * @return List<ActivoFijo>
	 */
	public List<ActivoFijo> findByType(int idTipo);

	/**
	 * Especificación de método encargado de retornar los Activos Fijos
	 * filtrados por Fecha de compra
	 * 
	 * @param buyDate
	 * @return
	 */
	public List<ActivoFijo> findByBuyDate(Date buyDate);

	/**
	 * Especificación de método encargado de retornar los Activos Fijos
	 * filtrados por serial
	 * 
	 * @param serial
	 * @return
	 */
	public List<ActivoFijo> findBySerial(String serial);

	/**
	 * Especificación de método encargado de guardar un activo Fijo que entra
	 * como parámetro
	 * 
	 * @param activoFijo
	 */
	public void save(ActivoFijo activoFijo);

	/**
	 * Especificación de método encargado de actualizar un activo Fijo que entra
	 * como parámetro
	 * 
	 * @param activoFijo
	 */
	public void update(ActivoFijo activoFijo);
}
