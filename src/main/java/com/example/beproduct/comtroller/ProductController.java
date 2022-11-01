package com.example.beproduct.comtroller;

import com.example.beproduct.entity.Product;
import com.example.beproduct.service.CategoryService;
import com.example.beproduct.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/api/products")
    public void saveProduct(@RequestBody Product product) {
        productService.saveProduct(product);
    }

    @GetMapping("/api/products")
    public List<Product> listProduct() {
        return productService.getAllProduct();
    }

    @PutMapping("/api/products/{id}")
    public void EditProductForm(@PathVariable("id") Integer id, @RequestBody Product product) {
        product.setId(id);
        productService.saveProduct(product);
    }

    @DeleteMapping("/api/products/{id}")
    public void DeleteProduct(@PathVariable("id") Integer id) {
        productService.deleteProduct(id);
    }

    @GetMapping("/api/products/{id}")
    public Product findProductById(@PathVariable("id")Integer id){
        return  productService.findProductById(id);
    }


}
