package com._520it.day2.di;

public class OtherBean {
	private String url;
	private String host;
	private String alibaba;
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getAlibaba() {
		return alibaba;
	}
	public void setAlibaba(String alibaba) {
		this.alibaba = alibaba;
	}
	@Override
	public String toString() {
		return "OtherBean [url=" + url + ", host=" + host + ", alibaba="
				+ alibaba + "]";
	}
	
	
}
