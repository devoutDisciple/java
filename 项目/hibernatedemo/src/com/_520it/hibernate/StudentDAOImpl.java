package com._520it.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com._520it.util.HibernateUtil;

public class StudentDAOImpl implements IStudentDAO {

	public void save(Student s) {
		Session session = HibernateUtil.getInstance().openSession();
		// ±£¥Ê∂‘œÛ
		Transaction tx = session.beginTransaction();
		session.save(s);
		tx.commit();
		session.close();
	}

	public void update(Student s) {
		Session session = HibernateUtil.getInstance().openSession();
		Transaction tx = session.beginTransaction();
		session.update(s);
		tx.commit();
		session.close();

	}

	public Student get(Long id) {

		Session session = HibernateUtil.getInstance().openSession();
		Transaction tx = session.beginTransaction();
		Student s = (Student) session.get(Student.class, id);
		tx.commit();
		session.close();
		return s;
	}

	@Override
	public void delete(Long id) {
		Student s = new Student();
		s.setId(id);
		Session session = HibernateUtil.getInstance().openSession();
		Transaction tx = session.beginTransaction();
		session.delete(s);
		tx.commit();
		session.close();

	}

	@Override
	public List<Student> list() {
		Session session = HibernateUtil.getInstance().openSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("SELECT s from Student s");
		@SuppressWarnings("unchecked")
		List<Student> list = query.list();
		tx.commit();
		session.close();
		return list;
	}

}
