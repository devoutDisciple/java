package com._520it.day2.aop;

import org.springframework.stereotype.Component;

@Component
public class AopDemo {
	public void getService() {
		System.out.println("getService");
	}

	public void saveService() {
		System.out.println("saveService");
	}

	public void afterService() {
		/*
		 * ���������ִ��󣬻�����after-throwing�������õķ���
		 * */		
		//int i = 1/0;
		System.out.println("afterService");
	}
}
