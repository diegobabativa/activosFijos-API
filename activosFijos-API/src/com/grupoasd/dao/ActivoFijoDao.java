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

	public List<ActivoFijo> findAll();

	public List<ActivoFijo> findByType(int idTipo);

	public List<ActivoFijo> findByBuyDate(Date buyDate);

	public List<ActivoFijo> findBySerial(String serial);
}
