package com.example.beproduct.service.impl;

import com.example.beproduct.entity.Product;
import com.example.beproduct.output.Exception;
import com.example.beproduct.repository.ProductRepository;
import com.example.beproduct.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements BaseService<Product> {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Page<Product> getAllPagingAndSorting(Pageable pageable, String query) {
        if (query==null || query.equals("null") || query.isEmpty())
            return productRepository.findAll(pageable);
        if (productRepository.getAllPagingAndSorting(pageable,query).isEmpty()){
            throw new Exception("Không tìm thấy phần tử nào!!!");
        }
        if(query.length()>1)
//            throw new Exception("Nhập sai!! query phải > 2 phần tử");
            return productRepository.getAllPagingAndSorting(pageable, query);
        else
            return productRepository.findAll(pageable);
    }


    @Override
    public Page<Product> getAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public List<Product> getAlllist() {
        return null;
    }

    @Override
    public Product getOneById(Integer id) {
        return productRepository.findById(id).get();
    }

    @Override
    public Product saveOrUpdate(Product entity) {
        return productRepository.save(entity);
    }

    @Override
    public boolean delete(Integer id) {
        productRepository.deleteById(id);
        return false;
    }

//    @Override
//    public List<Product> getProductByPage(Pageable pageable) {
//        List<Product> list = productRepository.findAll(pageable).getContent();
//        List<Product> data = new ArrayList<>();
//        for(Product i : list){
//                data.add(i);
//        }
//        return data;
//    }
//
//    @Override
//    public List<Product> getAllProduct() {
//        return productRepository.findAll();
//    }
//
//    @Override
//    public void saveProduct(Product product) {
//        Product old = new Product();
//        if (product.getId() != null) {
//            old = productRepository.findById(product.getId()).orElse(null);
//        }
//        if (product.getImage() == null) {
//            assert old != null;
//            product.setImage(old.getImage());
//        }
//        productRepository.save(product);
//    }
//
//    @Override
//    public void deleteProduct(Integer id) {
//        productRepository.deleteById(id);
//    }
//
//    @Override
//    public Product findProductById(Integer id) {
//        return productRepository.findById(id).get();
//    }
//
//    @Override
//    public int totalItem() {
//        return (int) productRepository.count();
//    }

}