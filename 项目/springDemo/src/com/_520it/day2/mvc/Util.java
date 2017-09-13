package com._520it.day2.mvc;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component
public class Util {
	public void save(){
		System.out.println("save");
	}
	
	/*
	 * ��ʾ�ڷ������ٵ�ʱ�����
	 * */	
	@PreDestroy
	public void get (){
		System.out.println("get");
	}
	
	/*
	 * ��ʾ�ڳ�ʼ����ʱ����ã��൱��init-method��һ������di֮��ִ�е�
	 * */	
	@PostConstruct
	public void init(){
		System.out.println("init");
	}
	
}
