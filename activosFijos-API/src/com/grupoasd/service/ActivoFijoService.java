package com.grupoasd.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupoasd.dao.ActivoFijoDao;
import com.grupoasd.pojo.ActivoFijo;

/**
 * Esta clase permite consultar los activos Fijos a través de una inyección de
 * ActivoFijoDao. Nos sirve para manejar condicionales en las validaciones de
 * los CRUD y dejar un Dao mucho más limpio y genérico que se pueda usar.
 * 
 * @author Diego Babativa
 * @since 21-02-2017
 */
@Service
public class ActivoFijoService {

	/**
	 * Atributos de la clase ActivoFijoService
	 */
	@Autowired
	ActivoFijoDao activoFijoDao;

	public ActivoFijo findById(int codigo) {
		return activoFijoDao.findById(codigo);
	}

	public List<ActivoFijo> findAll() {
		return activoFijoDao.findAll();
	}

	public List<ActivoFijo> findByType(int idTipo) {
		return activoFijoDao.findByType(idTipo);
	}

	public List<ActivoFijo> findByBuyDate(Date buyDate) {
		return activoFijoDao.findByBuyDate(buyDate);
	}

	public List<ActivoFijo> findBySerial(String serial) {
		return activoFijoDao.findBySerial(serial);
	}

	/**
	 * Método del servicio que valida Excepciones de Negocio para que sean
	 * escaladas al controlador.
	 * 
	 * @param activoFijo
	 */
	public void save(ActivoFijo activoFijo) {

		if (activoFijo.getFechaCompra().before(activoFijo.getFechaBaja())) {
			activoFijoDao.save(activoFijo);
		} else {
			throw new RuntimeException(
					"La fecha de Baja no puede ser Inferior a la de compra");
		}
	}

	/**
	 * Método del servicio que valida Excepciones de Negocio para que sean
	 * escaladas al controlador.
	 * 
	 * @param activoFijo
	 */
	public void update(ActivoFijo activoFijo) {

		ActivoFijo activoFijoEncontrado = activoFijoDao.findById(activoFijo
				.getCodigo());

		// Solo se permite modificar el serial interno y la fecha de Baja

		if (activoFijo.getSerial() != null
				|| activoFijo.getSerial().equalsIgnoreCase("")) {
			activoFijoEncontrado.setSerial(activoFijo.getSerial());
		} else {
			throw new RuntimeException(
					"Debe enviar información del serial interno para ser atualizado");
		}

		if (activoFijo.getFechaBaja() != null) {

			if (activoFijo.getFechaBaja().after(
					activoFijoEncontrado.getFechaCompra())) {
				activoFijoEncontrado.setFechaBaja(activoFijo.getFechaBaja());
			} else {
				throw new RuntimeException(
						"La fecha de Baja no debe ser menor a la fecha de Compra");
			}
		} else {
			throw new RuntimeException(
					"Debe enviar información de la Fecha de Baja para ser actualizada");
		}
		activoFijoDao.update(activoFijoEncontrado);
	}
}
