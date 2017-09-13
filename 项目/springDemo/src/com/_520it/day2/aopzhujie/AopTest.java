package com._520it.day2.aopzhujie;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class AopTest {

	@Autowired
	private AopDemo aopDemo;
	
	
	@Test
	public void test() {
		aopDemo.saveService();
	}

}
