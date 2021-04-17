package com.example.demo.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Category;
import com.example.demo.services.CategoryService;

@RestController
public class CategoryController {
	
	
	@Autowired
	CategoryService categoryService;
	
	@PostMapping("/addCategory")
	public ResponseEntity<Category> save(@RequestBody Category category) {
        Category newCategory = categoryService.saveCategory(category);
        return new ResponseEntity<>(newCategory,HttpStatus.CREATED);
    }
	
//	@GetMapping("/find/{name}")
//	 public ResponseEntity<Category> getCategory(@PathVariable("name") String name) {
//        Category category = categoryService.findCategoryByName(name);
//        return new ResponseEntity<>(category, HttpStatus.OK);
//	}
	
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
