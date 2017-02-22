package com.grupoasd.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.grupoasd.dao.AreaDao;
import com.grupoasd.pojo.Area;

@Transactional
@Repository
public class AreaDaoImpl implements AreaDao {
	
	@Autowired
	private SessionFactory sessionFActory;
	
	public Session getSession(){
		return sessionFActory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Area> findAll() {
		Query query = getSession().createQuery("from Area");
		return query.list();
	}
	
	

}
