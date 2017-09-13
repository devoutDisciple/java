package com._520it.service;

import java.util.List;

import com._520it.domain.Employee;

public interface IEmployeeService {
	
	public void save(Employee e);

	public void delete(Long id);

	public void update(Employee e);

	public Employee get(Long id);

	public List<Employee> list();
}
