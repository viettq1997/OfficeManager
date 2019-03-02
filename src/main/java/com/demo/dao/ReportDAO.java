package com.demo.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.model.Reports;

@Transactional
@Repository
public class ReportDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public List<Reports> getAllReportList() {
		Session ses = sessionFactory.getCurrentSession();
		List<Reports> list = ses.createQuery("From Reports").list();
		return list;
	}
}
