package com._520it.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com._520it.domain.Employee;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class ServiceTest {
	
	@Autowired
	IEmployeeService dao;
	
	@Before
	public void testSave() {
		Employee e = new Employee();
		e.setName("aaa");
		e.setPassword("gfdg");
		dao.save(e);
	}
	
	@Test
	public void test() {
//		Employee e = new Employee();
//		e.setName("aaa");
//		e.setPassword("gfdg");
//		dao.save(e);
		System.out.println(dao.list());
	}

}
