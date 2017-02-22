package com.grupoasd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupoasd.dao.TipoActivoFijoDao;
import com.grupoasd.pojo.TipoActivoFijo;

/**
 * Esta clase permite consultar los tipos de activos fijo através  de una inyección
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
	 * Método público encargado de retornar todos los registros
	 * de TipoActivoFijo
	 * @return Lista de tipo TipoActivoFijo
	 */
	public List<TipoActivoFijo> findAll(){
		return tipoActivoFijoDao.findAll();
	}

}
