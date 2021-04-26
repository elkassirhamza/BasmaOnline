package com.example.categories.services;

import com.example.categories.entity.Category;
import com.example.categories.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }


    @Override
    public Category findCategoryById(Long id) {
    	return categoryRepository.findCategoryById(id);
    	
    }

    @Override
    public Category getCategoryByName(String name) {
        return categoryRepository.findCategoryByName(name);
    }

    @Override
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(Long id) {
        Category category= categoryRepository.findCategoryById(id);
        System.out.println(category.getId());
        categoryRepository.deleteById(category.getId());
        

    }

    @Override
    public Category updateCategory(String newname,String name) {
        Category category= categoryRepository.findCategoryByName(name);
        category.setName(newname);
        categoryRepository.save(category);
        return category;
    }
}
