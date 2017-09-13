package com._520it.day1.toTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/*
 * 添加runwith标签
 * 告诉junit，在测试的时候先启动spring容器，完成之后关闭spring容器
 * 自动把当前的测试类添加到了spring容器中管理
 * */
@RunWith(SpringJUnit4ClassRunner.class)
/*引入该标签的时候会报错，需要引入context和expression的jar包
 * 告诉spring从什么地方加载配置文件
 * 如果该标签中不写配置文件地址，spring可以通过一个约定的方式找到配置文件
 * 必须满足1：和测试类在一个包里面
 * 2：这个配置文件的名字就叫做测试类-context.xml
 */
@ContextConfiguration("name.xml")
public class TestHelloworld {
	
	private IHelloWorld helloWorld;
	
	/*使用@Autowired标签，就自动的把spring创建好的容器的应用，设置给了这个字段
	 * */	
	@Autowired
	private BeanFactory beanFactory;

	@Test
	public void testBeans() {
		helloWorld = beanFactory.getBean("helloworld", IHelloWorld.class);
		helloWorld.save();
	}
	
	@Test
	public void testApplicationContext() {
	/*beanFactory是spring中最简单，最基本的容器，但是之日共了IOC/DI的功能
	 * 所以我们一般使用ApplicationContext
	 * ApplicationContext借口继承了BeanFactory的接口
	 * 提供额外的功能
	 * 1：环境感知
	 * 2：容器的集成体系
	 * 3：国际化相关
	 * 4：事件发布/相应机制
	 * 5：统一的资源管理
	 * 6：AOP的功能
	 * testApplicationContext2是ApplicationContext的更简单的写法
	 * */		
		@SuppressWarnings("resource")
		ApplicationContext cxt = new ClassPathXmlApplicationContext("/com/_520it/toTest/testdemo-context.xml");
		cxt.getBean("helloworld", IHelloWorld.class).get();;
	}
	
	/*
	 * ApplicationContext的更简单的写法
	 * */	
	@Autowired
	private ApplicationContext ctx2;
	
	@Test
	public void testApplicationContext2() {
		ctx2.getBean("helloworld", IHelloWorld.class).get();;
	}

}


























