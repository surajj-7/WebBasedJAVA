package com.blogs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogs.dto.ApiResponse;
import com.blogs.entities.Category;
import com.blogs.service.CategoryService;

/*
 * @Controller at class level + @ResponseBody implicitly added on return type
 * of request handling methods(@RequestMapping|@GetMapping|@PostMapping...)
 */
@RestController
@RequestMapping("/categories")//optional but recommended
public class CategoryController {
	//depcy-->service layer
	@Autowired //bytype
	private CategoryService categoryService;
	public CategoryController() {
		System.out.println("in ctor of "+getClass());
	}
	
	@GetMapping
	public List<Category> fetchAllCategories(){
		System.out.println("in list all Categories");
		return categoryService.getAllCategories();
	}
	
	/*
	 * Add new Category
	Design and end point of REST APIs for adding new Category(create)
	URL: http://host:port/categories
	Method:POST
	Payload(request data):Category details-->(name and desc):Category Entitiy
	JSON-->Java(de-ser|un-marshalling)
	Resp:@ResponseBody-->Category (with generated Id)
	 */
	@PostMapping
	public Category addNewCategory(@RequestBody Category category)
	{
		System.out.println("in addNewCategory "+category);
		return categoryService.addNewCategory(category);
	}
	
	/*
	 * Delete Category details
	Design and end point of REST APIs for deleting existing Category(delete)
	URL: http://host:port/categories/{categoryId}(URI template variable | path variable)
	Method:DELETE
	Payload(request data):NONE
	Resp:@ResponseBody-->Plain String message
	 */
	@DeleteMapping("/{categoryId}")
	//@PathVariable-->method arg level annotation, to bind incoming path variable to
	//the method argument
	public ApiResponse deleteCategoryDetails(@PathVariable Long categoryId) {
		System.out.println("in delete Category "+categoryId);
		return new ApiResponse(categoryService.deleteCategoryDetails(categoryId));
	}
	
	/*
	 * Get Category details by Id
	Design and end point of REST APIs for deleting existing Category(GET)
	URL: http://host:port/categories/{categoryId}(URI template variable | path variable)
	Method:GET
	Payload(request data):NONE
	Resp:@ResponseBody-->Category
	 */
	
	@GetMapping("/{categoryId}")
	public Category getCategoryDetails(@PathVariable Long categoryId){
		System.out.println("in get Category by "+categoryId);
		return categoryService.getCategoryDetails(categoryId);
	}
	
	/*
	 * Update Category details
	Design and end point of REST APIs for deleting existing Category(PUT)
	URL: http://host:port/categories
	Method:PUT
	Payload(request data):Category
	Resp:@ResponseBody-->Category
	 */
	
	@PutMapping
	public Category updateCategoryDetails(@RequestBody Category category) {
		System.out.println("in update "+category);
		return categoryService.updateCategoryDetails(category);
	}
	

}
