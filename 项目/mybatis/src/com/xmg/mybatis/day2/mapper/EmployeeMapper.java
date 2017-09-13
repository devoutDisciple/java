package com.xmg.mybatis.day2.mapper;

import java.util.List;

import com.xmg.mybatis.day2.domain.Department;
import com.xmg.mybatis.day2.domain.Employee;

public interface EmployeeMapper {
	
	void add(Employee e);
	
	Employee get(Long id);
	
	List<Department> list1();
	
	List<Department> list2();
}
