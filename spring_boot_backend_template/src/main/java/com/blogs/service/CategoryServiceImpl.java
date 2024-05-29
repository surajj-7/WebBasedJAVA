package com.blogs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blogs.custom_exceptions.ResourceNotFoundException;
import com.blogs.entities.Category;
import com.blogs.repository.CategoryRepository;

@Service // spring bean containing B.L
@Transactional
public class CategoryServiceImpl implements CategoryService {
	// depcy-->dao layer i/f
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public List<Category> getAllCategories() {
		return categoryRepository.findAll();
	}

	@Override
	public Category addNewCategory(Category newCategory) {
		// use the method inherited from CrudRepository
		// public T save(T entity)
		return categoryRepository.save(newCategory);
	}

	@Override
	public String deleteCategoryDetails(Long categoryId) {
		// use the method inherited from CrudRepository
		// public void deleteById(ID id)
		if (categoryRepository.existsById(categoryId)){
			categoryRepository.deleteById(categoryId);
			return "Category with categoryId " + categoryId + "deleted";
		}
		return "deleting category details failed!!! Invalid category Id";
	}

	@Override
	public Category getCategoryDetails(Long categoryId) {
		// inherited method-->Optional<Category>findById(Long categoryId)
		Optional<Category> optional = categoryRepository.findById(categoryId);
		
		return optional.orElseThrow(()->new ResourceNotFoundException("Invalid Category ID!!!"));
	}

	@Override
	public Category updateCategoryDetails(Category category) {
		//crudRepo:save
		return categoryRepository.save(category);
	}

}
