package com.xmg.mybatis.day2.mapper;

import com.xmg.mybatis.day2.domain.Department;

public interface DepartmentMapper {
	
	void add(Department dept);
	
	Department get(Long id);
}
