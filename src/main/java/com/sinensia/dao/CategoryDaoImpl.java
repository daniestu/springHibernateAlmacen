package com.sinensia.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.sinensia.model.Category;

public class CategoryDaoImpl implements CategoryDao{
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Override
	public void add(Category category) {
		Session session = getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		Integer categoryId = (Integer) session.save(category);
		tx.commit();
		if(categoryId >0 ) {
			System.out.println("Category is created with ID = " + categoryId);
		}
	}

	@Override
	public Category getById(Integer categoryId) {
		Session session = getSessionFactory().openSession();
		Category category = session.get(Category.class, categoryId);
		return category;
	}

	@Override
	public List<Category> getAll() {
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.createQuery("From Category");
		@SuppressWarnings("unchecked")
		List<Category> categoryList = query.getResultList();
		return categoryList;
	}

	@Override
	public void delete(Integer categoryId) {
		Session session = getSessionFactory().openSession();
		Category category = session.get(Category.class, categoryId);
		if( category != null) {
			Transaction tx = session.beginTransaction();
			session.delete(category);
			tx.commit();
			System.out.println("Category is deleted with Id = " + categoryId);
		}
	}

}
