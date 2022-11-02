package com.example.beproduct.service.impl;

import com.example.beproduct.entity.Product;
import com.example.beproduct.repository.ProductRepository;
import com.example.beproduct.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getProductByPage(Pageable pageable) {
        List<Product> list = productRepository.findAll(pageable).getContent();
        List<Product> data = new ArrayList<>();
        for(Product i : list){
                data.add(i);
        }
        return data;
    }

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public void saveProduct(Product product) {
        Product old = new Product();
        if (product.getId() != null) {
            old = productRepository.findById(product.getId()).orElse(null);
        }
        if (product.getImage() == null) {
            assert old != null;
            product.setImage(old.getImage());
        }
        productRepository.save(product);
    }

    @Override
    public void deleteProduct(Integer id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product findProductById(Integer id) {
        return productRepository.findById(id).get();
    }

    @Override
    public int totalItem() {
        return (int) productRepository.count();
    }

}