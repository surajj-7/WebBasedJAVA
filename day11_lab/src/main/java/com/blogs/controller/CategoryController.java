package com.blogs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/categories")
public class CategoryController {
	public CategoryController()
	{
		System.out.println("in ctor of "+getClass());
	}
	//add req handling method to list all categories
	@GetMapping("/list")
	public ModelAndView listAllCategories() {
		System.out.println("in list all categories");
		return new ModelAndView("/categories/list","category_list",null);
		//AVN-/WEB-INF/views/categories/list.jsp
	}
}
