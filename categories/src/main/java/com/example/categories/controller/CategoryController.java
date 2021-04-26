package com.example.categories.controller;

import com.example.categories.entity.Category;
import com.example.categories.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class CategoryController {
	
	
	@Autowired
	CategoryService categoryService;
	
	@PostMapping("/addCategory")
	public ResponseEntity<Category> save(@RequestBody Category category) {
        Category newCategory = categoryService.saveCategory(category);
        return new ResponseEntity<>(newCategory,HttpStatus.CREATED);
    }

	
	@GetMapping("/category/{name}")
	public ResponseEntity<Category> getCategory(@PathVariable("name") String name){
		Category category = categoryService.getCategoryByName(name);
		return new ResponseEntity<>(category, HttpStatus.OK);
	}
	
	
	@GetMapping("/find/{id}")
	 public ResponseEntity<Category> getCategory(@PathVariable("id") Long id) {
       Category category = categoryService.findCategoryById(id);
       return new ResponseEntity<>(category, HttpStatus.OK);
	}

	
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable("id") Long id) throws IOException {
    	System.out.println(id);
        categoryService.deleteCategory(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    @GetMapping("/list")
    public ResponseEntity<List<Category>> getAllCategories() {
        List<Category> categories = categoryService.getCategories();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }
	@PutMapping("/updateCategory")
	public ResponseEntity<Category> update(@RequestBody Category category) {
        Category newCategory = categoryService.saveCategory(category);
        return new ResponseEntity<>(newCategory,HttpStatus.ACCEPTED);
    }
    
      
    
}
