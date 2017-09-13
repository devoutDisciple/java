package com._520it.day1.di;

public class SomeBean {
	private Long id;
	private String name;
	private String password;
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
