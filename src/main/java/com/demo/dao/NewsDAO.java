package com.demo.dao;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.model.News;

@Transactional
@Repository
public class NewsDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public List<News> getAllNews() {
		Session ses = sessionFactory.getCurrentSession();
		List<News> listNews = ses.createQuery("From News").list();
		return listNews;
	}
	public boolean addNewNews(String title , String image,String dates,String contentt,int idStaff) {
		try {
			Session ses = sessionFactory.getCurrentSession();
			Query query = ses.createQuery("INSERT INTO News(title,image,dates,contentt,idStaff) VALUES(?,?,TO_DATE(?,'MMddyyyy'),?,?)");
			query.setParameter(0, title);
			query.setParameter(1, image);
			query.setParameter(2, dates);
			query.setParameter(3, contentt);
			query.setParameter(4, idStaff);
			query.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		
		}
	}
}
