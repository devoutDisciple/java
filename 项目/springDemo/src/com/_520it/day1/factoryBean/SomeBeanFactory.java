package com._520it.day1.factoryBean;

import org.springframework.beans.factory.FactoryBean;

public class SomeBeanFactory implements FactoryBean<Somebean>{

	/*
	 * 工厂创建bean的方法
	 * */	
	@Override
	public Somebean getObject() throws Exception {
		Somebean bean = new Somebean();
		bean.save();;
		return bean;
	}
	
	/*
	 * 方法返回工厂生产出来的对象的类型
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
