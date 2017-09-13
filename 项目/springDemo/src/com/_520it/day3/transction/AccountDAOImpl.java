package com._520it.day3.transction;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class AccountDAOImpl extends JdbcDaoSupport implements IAccountDAO {

	
	@Override
	public void transin(Long id,Double money) {
		this.getJdbcTemplate().update("UPDATE account SET money=money+? WHERE id=?",money,id );
	}

	@Override
	public void transout(Long id, Double money) {
		this.getJdbcTemplate().update("UPDATE account SET money=money-? WHERE id=?",money,id );
	}


}
