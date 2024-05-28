package com.blogs.controller;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //mandatory class level annotation to tell SC,
//following is req handling spring bean
//singleton n eager
public class TestController {
	public TestController() {
		System.out.println("in ctorof "+getClass());
	}
	
	//add init method
	@PostConstruct
	public void myInit(){
		System.out.println("in init of "+getClass());
	}
	
	//add a req handling method to forward the client to the view layer
	//to display welcome message
	@RequestMapping("/test1")
	public String testMe(){
		System.out.println("in testMe");
		return "/display"; //LVN, Handler return LVN-->Dispatcher Servlet-->V.R
		//-->PREFIX+LVN+SUFFIX-->AVN TO D.S
		//AVN-/WEB-INF/views/display.jsp
	}
	
}
