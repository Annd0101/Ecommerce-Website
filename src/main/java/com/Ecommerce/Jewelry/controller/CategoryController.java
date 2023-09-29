package com.Ecommerce.Jewelry.controller;


import com.Ecommerce.Jewelry.common.ApiResponse;
import com.Ecommerce.Jewelry.model.Category;
import com.Ecommerce.Jewelry.service.CategoryService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @PostMapping("/create")
    public ResponseEntity<ApiResponse> createCategory(@RequestBody Category category){
        categoryService.createCategory(category);
        return new ResponseEntity<>(new ApiResponse(true,"A new category is created"), HttpStatus.CREATED);
    }
    @GetMapping("/list")
    public List<Category> listCategory() {
        return categoryService.listCategory();
    }
    @PostMapping("/category/{categoryId}")
    public ResponseEntity<ApiResponse> updateCategory(@PathVariable int categoryId, @RequestBody Category category){
        if(!categoryService.findById(categoryId)){
            return new ResponseEntity<>(new ApiResponse(false,"Category does not exist!"), HttpStatus.NOT_FOUND);
        }
        categoryService.updateCategory(categoryId, category);
        return new ResponseEntity<>(new ApiResponse(true,"Category updated"),HttpStatus.OK);
    }
}
