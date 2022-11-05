package com.example.beproduct.comtroller;

import com.example.beproduct.entity.Category;
import com.example.beproduct.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/api/categories")
    public List<Category> list(){
        return categoryService.getAllCategory();
    }


    //add
    @PostMapping("/api/categories/")
    public void addCategory(@RequestBody Category category){
        String oldCategory= category.getName();
        Category newName = categoryService.getCategoryByName(oldCategory);
        if(newName!=null) {
            System.out.println( "Tên danh mục đã tồn tại");
        }
        categoryService.saveCategory(category);
    }

    //edit
    @PutMapping("/api/categories/{id}")
    public void editCategory(@PathVariable("id") Integer id, @RequestBody Category category) {
        category.setId(id);
        categoryService.saveCategory(category);
    }

    @GetMapping("/api/categories/{id}")
    public Category findCategoryById(@PathVariable("id")Integer id){
        return  categoryService.findCategoryById(id);
    }

    @GetMapping("/api/categories/name/{name}")
    public Category findCategoryByName(@PathVariable("name")String name){
        return categoryService.getCategoryByName(name);
    }

    @DeleteMapping("/api/categories/{id}")
    public void DeleteCategory(@PathVariable("id") Integer id) {
        categoryService.deleteCategory(id);
    }
}
