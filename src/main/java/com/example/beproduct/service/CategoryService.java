package com.example.beproduct.service;


import com.example.beproduct.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategory();

    Category saveCategory(Category category);

    Category findCategoryById(Integer id);

    void deleteCategory(Integer id);

    Category getCategoryByName(String name);
}
