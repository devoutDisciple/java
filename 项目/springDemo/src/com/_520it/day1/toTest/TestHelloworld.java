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
 * ���runwith��ǩ
 * ����junit���ڲ��Ե�ʱ��������spring���������֮��ر�spring����
 * �Զ��ѵ�ǰ�Ĳ�������ӵ���spring�����й���
 * */
@RunWith(SpringJUnit4ClassRunner.class)
/*����ñ�ǩ��ʱ��ᱨ����Ҫ����context��expression��jar��
 * ����spring��ʲô�ط����������ļ�
 * ����ñ�ǩ�в�д�����ļ���ַ��spring����ͨ��һ��Լ���ķ�ʽ�ҵ������ļ�
 * ��������1���Ͳ�������һ��������
 * 2����������ļ������־ͽ���������-context.xml
 */
@ContextConfiguration("name.xml")
public class TestHelloworld {
	
	private IHelloWorld helloWorld;
	
	/*ʹ��@Autowired��ǩ�����Զ��İ�spring�����õ�������Ӧ�ã����ø�������ֶ�
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
	/*beanFactory��spring����򵥣������������������֮�չ���IOC/DI�Ĺ���
	 * ��������һ��ʹ��ApplicationContext
	 * ApplicationContext��ڼ̳���BeanFactory�Ľӿ�
	 * �ṩ����Ĺ���
	 * 1��������֪
	 * 2�������ļ�����ϵ
	 * 3�����ʻ����
	 * 4���¼�����/��Ӧ����
	 * 5��ͳһ����Դ����
	 * 6��AOP�Ĺ���
	 * testApplicationContext2��ApplicationContext�ĸ��򵥵�д��
	 * */		
		@SuppressWarnings("resource")
		ApplicationContext cxt = new ClassPathXmlApplicationContext("/com/_520it/toTest/testdemo-context.xml");
		cxt.getBean("helloworld", IHelloWorld.class).get();;
	}
	
	/*
	 * ApplicationContext�ĸ��򵥵�д��
	 * */	
	@Autowired
	private ApplicationContext ctx2;
	
	@Test
	public void testApplicationContext2() {
		ctx2.getBean("helloworld", IHelloWorld.class).get();;
	}

}


























