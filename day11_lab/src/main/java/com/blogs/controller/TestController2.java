package com.blogs.controller;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
//base pattern of the incoming url-pattern, 
//can be supplied at the class level-->optional but recommended
@RequestMapping("/test")//can intercept any req(GET|POST|PUT|DELETE|PATCH)
public class TestController2 {
	public TestController2() {
		System.out.println("in ctor of "+getClass());
	}
	//add a req handling method to display server side time stamp
	//(i.e a dynamic response)
	@GetMapping("/test2")//it is equivalent to req mapping (method=GET)
	public ModelAndView renderDynamicResult() {
		System.out.println("in renderDynamicResult");
		/*
		 * o.s.w.s ModelAndView : class that holds LVN + results
		 * Results are represented by model attributes
		 * (name, value pair)
		 * Constructor:
		 * ModelAndView(String LVN, String modelAttrName, Object modelAttrValue)
		 */
		 return new ModelAndView("/test/display","server_ts",LocalDateTime.now());
		 /*
		  * Handler rets ModelAndView to D.S
		  * D.S sends LVN-->V.R-->AVN(/WEB-INF/views/test/display.jsp)-->D.S
		  * --> D.S adds model attributes under the request scope and then forward the 
		  * client to the JSP
		  * 
		  */
	}
}
