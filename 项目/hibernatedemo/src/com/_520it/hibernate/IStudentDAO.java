package com._520it.hibernate;

import java.util.List;

public interface IStudentDAO {
	public void save(Student s);
	
	public void update(Student s);
	
	public Student get(Long id);
	
	public void delete(Long id);
	
	public List<Student> list();

}
