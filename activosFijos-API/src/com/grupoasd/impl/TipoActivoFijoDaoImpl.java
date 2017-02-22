package com.grupoasd.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.grupoasd.dao.TipoActivoFijoDao;
import com.grupoasd.pojo.TipoActivoFijo;


@Transactional
@Repository
public class TipoActivoFijoDaoImpl implements TipoActivoFijoDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<TipoActivoFijo> findAll() {
		Query query = getSession().createQuery("from TipoActivoFijo");
		return query.list();
	}

}
