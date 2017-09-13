package com._520it.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;

import com._520it.util.HibernateUtil;

public class TestStudent {

	private IStudentDAO dao = new StudentDAOImpl();
	@Before
	public void testSave() {
		Student s = new Student();
		s.setUsername("zhangzhen");
		s.setPassword("22");
		dao.save(s);
	}
	
	@Test
	public void testGet() {
		Student s = dao.get(5L);
		System.out.println(s);
	}
	
	@Test
	public void testUpdate() {
		Student s = dao.get(5L);
		System.out.println(s);
		s.setUsername("÷‹ƒ»");
		dao.update(s);
	}
	
	@Test
	public void testDelete() {
		dao.delete(5L);
	}
	
	@Test
	public void testList() {
		List<Student> s = dao.list();
		System.out.println(s);
	}
	
	@Test
	public void testTansaction() {
		Student s = new Student();
		s.setId(1L);
		
		Session session = null;
		try {
			session = HibernateUtil.getInstance().openSession();
			session.beginTransaction();
			session.delete(s);
			session.getTransaction().commit();
		} catch (Exception e) {
				if(session != null && session.beginTransaction().isActive()){
					session.getTransaction().rollback();
				}
		} finally {
			if(session != null && session.isOpen()){
				session.close();
			}
		}
	}

}
