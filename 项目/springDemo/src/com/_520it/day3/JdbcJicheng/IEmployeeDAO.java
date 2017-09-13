package com._520it.day3.JdbcJicheng;

import java.util.List;

public interface IEmployeeDAO {

	public void save(Employee e);

	public Employee get(Long id);

	public void update(Employee e);

	public void delete(Long id);

	public List<Employee> list();

}
