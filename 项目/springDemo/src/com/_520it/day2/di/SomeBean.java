package com._520it.day2.di;

import org.springframework.beans.factory.annotation.Autowired;

public class SomeBean {
	private Long id;
	private String name;
	private String password;
	
	/*
	 * 可以直接在这里使用@Autowired，但是bean也要在配置文件中配置,可以放在字段上，也可以放在setter方法上
	 * 可以通过aurowired的required=false让这个属性可以没有值
	 * */	
	@Autowired
	private OtherBean otherBean;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public OtherBean getOtherBean() {
		return otherBean;
	}
	public void setOtherBean(OtherBean otherBean) {
		this.otherBean = otherBean;
	}
	@Override
	public String toString() {
		return "SomeBean [id=" + id + ", name=" + name + ", password="
				+ password + ", otherBean=" + otherBean + "]";
	}
	
	
	
	
	
}
