package com.example.categories.services;

import com.example.categories.entity.Category;

import java.util.List;

public interface CategoryService {
	
	 	List<Category> getCategories();
	    Category getCategoryByName(String name);
	    Category saveCategory(Category category);
	    public void deleteCategory(Long id) ;
	    Category updateCategory(String newname,String name) ;
		Category findCategoryById(Long id);

}
