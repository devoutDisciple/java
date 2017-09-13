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
	 * 表示在方法销毁的时候调用
	 * */	
	@PreDestroy
	public void get (){
		System.out.println("get");
	}
	
	/*
	 * 表示在初始化的时候调用，相当于init-method，一定是在di之后执行的
	 * */	
	@PostConstruct
	public void init(){
		System.out.println("init");
	}
	
}
