package com.xmg.mybatis.query;

public class QueryObject {
private String name;
	
	private int beginAge = -1;
	
	private int endAge = -1;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBeginAge() {
		return beginAge;
	}

	public void setBeginAge(int beginAge) {
		this.beginAge = beginAge;
	}

	public int getEndAge() {
		return endAge;
	}

	public void setEndAge(int endAge) {
		this.endAge = endAge;
	}
	
}


