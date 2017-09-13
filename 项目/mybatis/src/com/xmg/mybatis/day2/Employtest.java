package com.xmg.mybatis.day2;


import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.xmg.mybatis.day2.domain.Department;
import com.xmg.mybatis.day2.domain.Employee;
import com.xmg.mybatis.day2.mapper.DepartmentMapper;
import com.xmg.mybatis.day2.mapper.EmployeeMapper;
import com.xmg.mybatis.util.MybatisUtil;

public class Employtest {
	
	private EmployeeMapper employeeMapper;
	
	private DepartmentMapper deptMapper;

	@Test
	public void testAdd() {
		SqlSession session = MybatisUtil.getSession();
		employeeMapper = session.getMapper(EmployeeMapper.class);
		deptMapper = session.getMapper(DepartmentMapper.class);
		
		Department dept = new Department();
		dept.setName("666");
		
		Employee e = new Employee();
		e.setName("777");
		e.setDept(dept);
		
		deptMapper.add(dept);
		employeeMapper.add(e);
		
		session.commit();
		session.close();
	}
	
	
	@Test
	public void testGet() {
		SqlSession session = MybatisUtil.getSession();
		employeeMapper = session.getMapper(EmployeeMapper.class);
		Employee e = employeeMapper.get(10L);
		System.out.println(e);
		session.commit();
		session.close();		
	}
	
	@Test
	public void tesList1() {
		SqlSession session = MybatisUtil.getSession();
		employeeMapper = session.getMapper(EmployeeMapper.class);
		List<Department> list = employeeMapper.list1();
		System.out.println(list);
		session.commit();
		session.close();		
	}
	
	@Test
	public void tesList2() {
		SqlSession session = MybatisUtil.getSession();
		employeeMapper = session.getMapper(EmployeeMapper.class);
		List<Department> list = employeeMapper.list2();
		System.out.println(list);
		session.commit();
		session.close();		
	}

}
