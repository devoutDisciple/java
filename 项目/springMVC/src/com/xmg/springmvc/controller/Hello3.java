package com.xmg.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Hello3 {

	@RequestMapping("/Hellodemo")
	public ModelAndView demo(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("upload.jsp");
		return mv;
	}
}
