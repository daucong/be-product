package com.example.beproduct.comtroller;

import com.example.beproduct.entity.Category;
import com.example.beproduct.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/categories")
public class CategoryController {
    @Autowired
    private BaseService<Category> categoryService;

    @GetMapping("")
    public List<Category> list() {
        return categoryService.getAlllist();
    }

    //add
    @PostMapping("")
    public void addCategory(@RequestBody Category category) {
        categoryService.saveOrUpdate(category);
    }

    @GetMapping("/{id}")
    public Category findCategoryById(@PathVariable("id") Integer id) {
        return categoryService.getOneById(id);
    }


    @DeleteMapping("/{id}")
    public void DeleteCategory(@PathVariable("id") Integer id) {
        categoryService.delete(id);
    }
}
