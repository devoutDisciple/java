package com._520it.day2.aopzhujie;

import org.springframework.stereotype.Component;

@Component
public class AopDemo {
	public void getService() {
		System.out.println("getService");
	}

	public void saveService() {
		//int i = 1/0;
		System.out.println("saveService");
	}

	public void afterService() {
		/*
		 * 如果这里出现错误，会运行after-throwing里面配置的方法
		 * */		
		//int i = 1/0;
		System.out.println("afterService");
	}
}
