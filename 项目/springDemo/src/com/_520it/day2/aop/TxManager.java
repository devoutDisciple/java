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
	 * �������ļ�����������������쳣�������������
	 * */	
	public void after(Throwable ex) {
		System.out.println("after"+ex.getMessage());
	}
}
