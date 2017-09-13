package com._520it.day2.aop;

import org.springframework.stereotype.Component;

@Component
public class TxManager {
	public void save() {
		System.out.println("save");
	}

	public void get() {
		System.out.println("get");
	}

	/*
	 * 在配置文件中配置了如果出现异常会运行这个方法
	 * */	
	public void after(Throwable ex) {
		System.out.println("after"+ex.getMessage());
	}
}
