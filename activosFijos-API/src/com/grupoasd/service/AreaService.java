package com.grupoasd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupoasd.dao.AreaDao;
import com.grupoasd.pojo.Area;

/**
 * Esta clase permite consultar los activos Fijos a través de una inyección
 * de AreaDao.
 * 
 * @author Diego Babativa
 * @since 21-02-2017 
 */
@Service
public class AreaService {

	@Autowired
	private AreaDao areaDao;
	
	public List<Area> findAll(){
		return areaDao.findAll();
	}
	
}
