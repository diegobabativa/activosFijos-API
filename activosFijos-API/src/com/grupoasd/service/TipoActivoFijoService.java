package com.grupoasd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupoasd.dao.TipoActivoFijoDao;
import com.grupoasd.pojo.TipoActivoFijo;

/**
 * Esta clase permite consultar los tipos de activos fijo atrav�s  de una inyecci�n
 * de TipoActivoFijoDao
 * 
 * @author Diego Babativa
 * @since 21-02-2017 
 */
@Service
public class TipoActivoFijoService {
	
	@Autowired
	private TipoActivoFijoDao tipoActivoFijoDao;
	
	/**
	 * M�todo p�blico encargado de retornar todos los registros
	 * de TipoActivoFijo
	 * @return Lista de tipo TipoActivoFijo
	 */
	public List<TipoActivoFijo> findAll(){
		return tipoActivoFijoDao.findAll();
	}

}
