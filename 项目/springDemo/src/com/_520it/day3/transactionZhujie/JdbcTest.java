package com._520it.day3.transactionZhujie;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class JdbcTest {

	@Autowired
	private IAccountService dao;
	
	@Test
	public void test() {
		dao.transfer(1L, 2L, 1000D);
	}

}
