package com.example.demo.services;

import java.util.List;
import com.example.demo.entity.Category;

public interface CategoryService {
	
	 	List<Category> getCategories();
	    Category getCategoryByName(String name);
	    Category saveCategory(Category category);
	    public void deleteCategory(Long id) ;
	    Category updateCategory(String newname,String name) ;
		Category findCategoryById(Long id);

}
