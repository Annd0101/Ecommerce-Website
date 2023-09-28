package com.Ecommerce.Jewelry.service;

import com.Ecommerce.Jewelry.model.Category;
import com.Ecommerce.Jewelry.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;
    public void createCategory(Category category) {
        categoryRepository.save(category);
    }
}
