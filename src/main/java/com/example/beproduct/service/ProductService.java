package com.example.beproduct.service;

import com.example.beproduct.entity.Product;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    List<Product> getProductByPage(Pageable pageable);
    List<Product> getAllProduct();
    void saveProduct( Product product);

    void deleteProduct(Integer id);
    Product findProductById(Integer id);

    int totalItem();
}
