package com._520it.day2.mvc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class SomeBeandiTest {

	@Autowired
	private SomeBean someBean;
	
	@Autowired
	private Util util;
	
	@Test
	public void testSomeBean() {
		util.save();
		System.out.println(someBean);
	}
	
}
