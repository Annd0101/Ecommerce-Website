package com.Ecommerce.Jewelry.service;

import com.Ecommerce.Jewelry.model.Category;
import com.Ecommerce.Jewelry.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;
    public void createCategory(Category category) {
        categoryRepository.save(category);
    }
    public List<Category> listCategory() {
        return categoryRepository.findAll();
    }
    public void updateCategory(int categoryId, Category updateCategory){
        Category category = categoryRepository.getById(categoryId);
        category.setCategoryName(updateCategory.getCategoryName());
        category.setDescription(updateCategory.getDescription());
        category.setImageUrl(updateCategory.getImageUrl());
        categoryRepository.save(category);
    }
    public boolean findById(int categoryId) {
        return categoryRepository.findById(categoryId).isPresent();
    }
}
