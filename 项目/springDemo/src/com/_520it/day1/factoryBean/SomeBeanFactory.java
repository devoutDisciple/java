package com._520it.day1.factoryBean;

import org.springframework.beans.factory.FactoryBean;

public class SomeBeanFactory implements FactoryBean<Somebean>{

	/*
	 * ��������bean�ķ���
	 * */	
	@Override
	public Somebean getObject() throws Exception {
		Somebean bean = new Somebean();
		bean.save();;
		return bean;
	}
	
	/*
	 * �������ع������������Ķ��������
	 * */	
	@Override
	public Class<?> getObjectType() {
		return Somebean.class;
	}

	@Override
	public boolean isSingleton() {
		// TODO Auto-generated method stub
		return true;
	}
	
}
