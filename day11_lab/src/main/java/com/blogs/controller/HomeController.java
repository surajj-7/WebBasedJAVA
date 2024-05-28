package com.blogs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	public HomeController() {
		System.out.println("in ctorof "+getClass());
	}
	
	@RequestMapping("/")
	public String IndexPage(){
		System.out.println("in indexPage");
		return "/index";
	}
}
