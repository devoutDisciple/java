package com._520it.day3.transactionZhujie;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements IAccountDAO {
	//��Ϊ�����ļ��в�û��jdbctempalte�������Բ������������@Autowired	
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
