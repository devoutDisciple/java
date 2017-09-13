package com._520it.day2.IoCzhujie;

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
	
	/*
	 * 也可以写成下面这种格式
	 * */	
	@Autowired
	private SomeBean someBean;
	
	@Test
	public void testSomeBean() {
		System.out.println(someBean);
	}
	
	@Test
	public void testdi() {
		SomeBean somebean2 = ctx.getBean("somebean", SomeBean.class);
		System.out.println(somebean2);
	}

}
