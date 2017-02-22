package com.grupoasd.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.grupoasd.dao.ActivoFijoDao;
import com.grupoasd.pojo.ActivoFijo;

@Transactional
@Repository
public class ActivoFijoDaoImpl implements ActivoFijoDao {

	@Autowired
	private SessionFactory sessionFActory;
	
	public Session getSession(){
		return sessionFActory.getCurrentSession();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ActivoFijo> findAll() {
		Query query = getSession().createQuery("from activofijo");
		return query.list();
	}

}
