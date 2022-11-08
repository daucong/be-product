package com.example.beproduct.repository;

import com.example.beproduct.entity.Category;
import com.example.beproduct.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

//public interface ProductRepository extends JpaRepository<Product, Integer> {
//}
public interface ProductRepository extends PagingAndSortingRepository<Product, Integer> {
//    Page<Product> findAllByNameContainingOrCategoryContaining(String name,String c, Pageable pageable);
//
//    List<Product> findAllByCategory(Category category, Pageable pageable);

}