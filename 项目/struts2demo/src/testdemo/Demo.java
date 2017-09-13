package testdemo;

import com.opensymphony.xwork2.ActionSupport;


public class Demo extends ActionSupport{

	private static final long serialVersionUID = 1L;
	
	public String execute() throws Exception {
		System.out.println("hello");
		return "list";
	}
	
}
