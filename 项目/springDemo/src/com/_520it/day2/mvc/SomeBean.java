package com._520it.day2.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/*
 * ʹ��IoC��ע�⣬�������ϼ�anntation
 * 1��@Component��һ��д�ڹ���������
 * 2��@Serviceһ��д�ڷ��������
 * 3��@Repository��һ��д��DAO����
 * 4��@Controller��һ��д��Action���� ,������springMVC�У�Controller���ڱ�ʾһ��Controller����
 * */
@Component("somebean")
public class SomeBean {
	private Long id;
	private String name;
	private String password;
	
	/*
	 * ����ֱ��������ʹ��@Autowired������beanҲҪ�������ļ�������,���Է����ֶ��ϣ�Ҳ���Է���setter������
	 * ����ͨ��aurowired��required=false��������Կ���û��ֵ
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
