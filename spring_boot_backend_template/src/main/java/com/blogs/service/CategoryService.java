package com.blogs.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.blogs.entities.Category;

public interface CategoryService {
	//add a method for getting all Categories
	List<Category> getAllCategories();

	//add a method for adding new Category
	Category addNewCategory(Category newCategory);
	
	//add a method for adding new Category
	String deleteCategoryDetails(@PathVariable Long categoryId);
	
	//add a method for getting CategoryDeatils
	Category getCategoryDetails(Long categoryId);
	
	//add a method to update CategoryDetails
	Category updateCategoryDetails(Category category);
}
