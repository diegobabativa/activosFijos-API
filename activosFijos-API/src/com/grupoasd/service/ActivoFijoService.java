package com.grupoasd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupoasd.dao.ActivoFijoDao;
import com.grupoasd.pojo.ActivoFijo;

/**
 * Esta clase permite consultar los activos Fijos a través de una inyección
 * de ActivoFijoDao. Nos sirve para manejar condicionales en las validaciones
 * de los CRUD y dejar un Dao mucho más limpio y genérico que se pueda usar.
 * 
 * @author Diego Babativa
 * @since 21-02-2017 
 */
@Service
public class ActivoFijoService {

	@Autowired
	ActivoFijoDao activoFijoDao;
	
	public List<ActivoFijo> findAll(){
		return activoFijoDao.findAll();
	}
	
}
