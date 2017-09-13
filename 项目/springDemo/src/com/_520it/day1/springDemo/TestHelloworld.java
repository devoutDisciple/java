package com._520it.day1.springDemo;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;


@SuppressWarnings("deprecation")
public class TestHelloworld {
	
	private IHelloWorld helloWorld;

	@Test
	public void testBeans() {
		Resource resource = new ClassPathResource("applicationContext.xml");
		
		BeanFactory beanFactory = new XmlBeanFactory(resource);
		helloWorld = beanFactory.getBean("helloword", IHelloWorld.class);
		helloWorld.save();
	}

}
