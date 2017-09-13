package com._520it.dao;

import java.util.List;

import com._520it.domain.Employee;

public interface IEmployeeDAO {
	
	public void save(Employee e);

	public void delete(Long id);

	public void update(Employee e);

	public Employee get(Long id);

	public List<Employee> list();
}
