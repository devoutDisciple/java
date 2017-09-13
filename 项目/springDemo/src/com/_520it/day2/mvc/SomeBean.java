package com._520it.day2.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/*
 * 使用IoC的注解，在类型上加anntation
 * 1：@Component：一般写在工具类上面
 * 2：@Service一般写在服务对象上
 * 3：@Repository：一般写在DAO上面
 * 4：@Controller：一般写在Action上面 ,并且在springMVC中，Controller就在标示一个Controller对象
 * */
@Component("somebean")
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
