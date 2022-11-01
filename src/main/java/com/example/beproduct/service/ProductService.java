package com.example.beproduct.service;

import com.example.beproduct.entity.Product;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService {
    List<Product> getAllProduct();

    void saveProduct( Product product);

    void deleteProduct(Integer id);
    Product findProductById(Integer id);
}
