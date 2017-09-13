package com._520it.service.impl;

import java.util.List;

import com._520it.dao.impl.EmployeeDAOImpl;
import com._520it.domain.Employee;
import com._520it.service.IEmployeeService;

public class EmployeeServiceImpl implements IEmployeeService {
	
	private EmployeeDAOImpl dao;
	

	public EmployeeDAOImpl getDao() {
		return dao;
	}

	public void setDao(EmployeeDAOImpl dao) {
		this.dao = dao;
	}

	public void save(Employee e) {
		dao.save(e);

	}

	public void delete(Long id) {
		dao.get(id);
	}

	public void update(Employee e) {
		dao.update(e);
	}

	public Employee get(Long id) {
		return dao.get(id);
	}

	public List<Employee> list() {
		return dao.list();
	}

}
