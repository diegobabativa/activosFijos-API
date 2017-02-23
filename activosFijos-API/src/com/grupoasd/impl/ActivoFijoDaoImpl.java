package com.grupoasd.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.grupoasd.dao.ActivoFijoDao;
import com.grupoasd.pojo.ActivoFijo;

/**
 * Clase encargada de hacer la inyección de dependencia de SessionFactory para
 * realizar las consultas HQL
 * 
 * @author Diego Babativa
 * @since 23-02-2017
 */
@Transactional
@Repository
public class ActivoFijoDaoImpl implements ActivoFijoDao {

	/**
	 * Atributos de la clase
	 */
	@Autowired
	private SessionFactory sessionFActory;

	public Session getSession() {
		return sessionFActory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ActivoFijo> findAll() {
		Query query = getSession().createQuery("from ActivoFijo");
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ActivoFijo> findByType(int idTipo) {
		Query query = getSession().createQuery(
				"from ActivoFijo where codigoTipoActivo = :idTipo ")
				.setParameter("idTipo", idTipo);
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ActivoFijo> findByBuyDate(Date buyDate) {
		Query query = getSession().createQuery(
				"from ActivoFijo where fechaCompra = :fechaCompra ")
				.setParameter("fechaCompra", buyDate);
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ActivoFijo> findBySerial(String serial) {
		Query query = getSession().createQuery(
				"from ActivoFijo where serial = :serial ").setParameter(
				"serial", serial);
		return query.list();
	}

}
