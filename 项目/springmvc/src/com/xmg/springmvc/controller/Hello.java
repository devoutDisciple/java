package com.xmg.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class Hello implements Controller{

	public ModelAndView handleRequest(HttpServletRequest req,
			HttpServletResponse resp) throws Exception {
		String user = req.getParameter("user");
		System.out.println(user);
		ModelAndView mv = new ModelAndView();
		mv.addObject("key", user);
		mv.setViewName("hello.jsp");
		return mv;
	}

}
