package com.grupoasd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupoasd.dao.CiudadDao;
import com.grupoasd.pojo.Ciudad;

/**
 * Esta clase permite consultar las ciudades a través de una inyección
 * de CiudadDao
 * 
 * @author Diego Babativa
 * @since 21-02-2017 
 */

@Service
public class CiudadService {

	@Autowired
	private CiudadDao ciudadDao;

	public List<Ciudad> findAll() {
		return ciudadDao.findAll();
	}

}
