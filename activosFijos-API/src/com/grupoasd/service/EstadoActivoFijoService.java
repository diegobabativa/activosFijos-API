package com.grupoasd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupoasd.dao.EstadoActivoFijoDao;
import com.grupoasd.pojo.EstadoActivoFijo;

/**
 * Esta clase permite consultar los Estados Activos a través de una inyección
 * de EstadoActivoFijoDao
 * @author Diego Babativa
 * @since  21-02-2017
 */
@Service
public class EstadoActivoFijoService {
	
	@Autowired
	private EstadoActivoFijoDao estadoActivoFijoDao;
	
	public List<EstadoActivoFijo> findAll(){
		return estadoActivoFijoDao.findAll();
	}

}
