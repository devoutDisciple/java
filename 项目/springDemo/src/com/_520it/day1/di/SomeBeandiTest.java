package com._520it.day1.di;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration

public class SomeBeandiTest {

	@Autowired
	private ApplicationContext ctx;
	
	@Test
	public void testdi() {
		SomeBean somebean = ctx.getBean("somebean", SomeBean.class);
		System.out.println(somebean);
	}

}
