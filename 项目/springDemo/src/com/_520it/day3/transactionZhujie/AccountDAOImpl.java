package com._520it.day3.transactionZhujie;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements IAccountDAO {
	//因为配置文件中并没有jdbctempalte对象，所以不能再它上面加@Autowired	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource){
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public void transin(Long id,Double money) {
		jdbcTemplate.update("UPDATE account SET money=money+? WHERE id=?",money,id );
	}

	public void transout(Long id, Double money) {
		jdbcTemplate.update("UPDATE account SET money=money-? WHERE id=?",money,id );
	}


}
