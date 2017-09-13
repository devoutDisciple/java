package com.xmg.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Hello2 {

	@RequestMapping("/demo")
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
