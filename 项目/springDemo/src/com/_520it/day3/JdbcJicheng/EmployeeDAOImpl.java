package com._520it.day3.JdbcJicheng;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class EmployeeDAOImpl extends JdbcDaoSupport implements IEmployeeDAO {

	/*
	 * 获取jdbcTemplate的第一种方法 继承JdbcDaoSupport 使用this.getJdbcTemplate()方法获得
	 * 
	 * 
	 * 获取jdbcTemplate的第二中方法 private JdbcTemplate jdbcTemplate; public void
	 * setDataSource(DataSource dataSource) { this.jdbcTemplate = new
	 * JdbcTemplate(dataSource); }
	 */

	@Override
	public void save(Employee e) {
		this.getJdbcTemplate().update(
				"INSERT INTO employee(name,password) VALUES(?,?)", e.getName(),
				e.getPassword());
	}

	@Override
	public void delete(Long id) {
		this.getJdbcTemplate().update("DELETE FROM employee WHERE id = ?", id);

	}

	@Override
	public Employee get(Long id) {
		Employee e = this.getJdbcTemplate().query(
				"SELECT * FROM employee WHERE id = ?",
				new ResultSetExtractor<Employee>() {
					@Override
					public Employee extractData(ResultSet res)
							throws SQLException, DataAccessException {
						if (res.next()) {
							Employee e = new Employee();
							e.setId(res.getLong("id"));
							e.setName(res.getString("name"));
							e.setPassword(res.getString("password"));
							return e;
						}
						return null;
					}

				}, id);
		return e;
	}

	@Override
	public void update(Employee e) {
		this.getJdbcTemplate().update(
				"UPDATE employee SET name=?,password=? WHERE id=?",
				e.getName(), e.getPassword(), e.getId());

	}

	@Override
	public List<Employee> list() {
		List<Employee> wh = this.getJdbcTemplate().query(
				"SELECT * FROM employee",
				new ResultSetExtractor<List<Employee>>() {
					public List<Employee> extractData(ResultSet res)
							throws SQLException, DataAccessException {
						List<Employee> list = new ArrayList<Employee>();
						if (res.next()) {
							Employee e = new Employee();
							e.setId(res.getLong("id"));
							e.setName(res.getString("name"));
							e.setPassword(res.getString("password"));
							list.add(e);
						}
						return list;
					}

				});
		return wh;
	}

}
