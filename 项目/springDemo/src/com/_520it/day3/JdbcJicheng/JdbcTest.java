package com._520it.day3.JdbcJicheng;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class JdbcTest {

	@Autowired
	private IEmployeeDAO dao;

	@Test
	public void testSave() {
		Employee e = new Employee();
		e.setName("zhang");
		e.setPassword("zhen");
		dao.save(e);
	}

	@Test
	public void testGet() {
		System.out.println(dao.get(2L));
	}
	
	@Test
	public void testUpdate() {
		Employee employee = new Employee();
		employee.setId(2L);
		employee.setPassword("ssdfdfdf");
		dao.update(employee);
	}

	@Test
	public void testDelete() {
		dao.delete(2L);
	}

	@Test
	public void testList() {
		dao.list();
	}

}
