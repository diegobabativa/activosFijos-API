package com.grupoasd.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.grupoasd.dao.EstadoActivoFijoDao;
import com.grupoasd.pojo.EstadoActivoFijo;

@Transactional
@Repository
public class EstadoActivoFijoDaoImpl implements EstadoActivoFijoDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EstadoActivoFijo> findAll() {
		Query query = getSession().createQuery("from EstadoActivoFijo");
		return query.list();
	}

}
