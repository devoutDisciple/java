package com._520it.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com._520it.dao.IEmployeeDAO;
import com._520it.domain.Employee;

public class EmployeeDAOImpl implements IEmployeeDAO {

	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void save(Employee e) {
		Session session = sessionFactory.getCurrentSession();
		session.save(e);
	}

	public void delete(Long id) {
		Session session = sessionFactory.getCurrentSession();
		Employee e = new Employee();
		e.setId(id);
		session.delete(e);
	}

	public void update(Employee e) {
		Session session = sessionFactory.getCurrentSession();
		session.update(e);
	}

	public Employee get(Long id) {
		Session session = sessionFactory.getCurrentSession();
		return (Employee) session.get(Employee.class, id);

	}

	@SuppressWarnings("unchecked")
	public List<Employee> list() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("SELECT e FROM Employee e").list();
	}

}
