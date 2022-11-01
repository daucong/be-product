package com.example.beproduct.service.impl;

import com.example.beproduct.entity.Category;
import com.example.beproduct.repository.CategoryRepository;
import com.example.beproduct.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategory() {
        return (List<Category>) categoryRepository.findAll();
    }

    @Override
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }


    @Override
    public Category findCategoryById(Integer id) {
        return categoryRepository.findById(id).get();
    }

    @Override
    public void deleteCategory(Integer id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public Category getCategoryByName(String name) {
        List<Category> list = categoryRepository.findAll();//đưa all data vào list
        for(Category i : list){
            String cate1 = i.getName().toLowerCase(); //đưa name cũ vào cate1 chuyển nó thành chuỗi thời
            String cate2 = name.toLowerCase(); //chuyển name truyền vào về chữ thường
            if(cate1.equals(cate2))//nếu 2 đối tượng cate1 va cate2 có cùng 1 giá trị(true) -> return list
                return i;
        }
        return null;
    }
}