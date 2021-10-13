package com.curat.eshopbackend.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Category findById(Integer id) throws Exception {
        return categoryRepository
                .findById(id)
                .orElseThrow(() -> new Exception(String.format("Category with id %d not found", id)));
    }


    public Category findByName(String categoryName) {
        return categoryRepository.findByName(categoryName);
    }
}
