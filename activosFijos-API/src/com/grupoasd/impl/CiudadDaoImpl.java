package com.grupoasd.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.grupoasd.dao.CiudadDao;
import com.grupoasd.pojo.Ciudad;

@Transactional
@Repository
public class CiudadDaoImpl implements CiudadDao {
	
	@Autowired
	private SessionFactory sessionFActory;
	
	public Session getSession(){
		return sessionFActory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Ciudad> findAll() {
		Query query = getSession().createQuery("from Ciudad");
		return query.list();
	}
	

}
