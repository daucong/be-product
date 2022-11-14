package com.example.beproduct.repository;

import com.example.beproduct.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends PagingAndSortingRepository<Product, Integer> {
//    Page<Product> findAllByNameContainingOrCategoryContaining(String name,String c, Pageable pageable);

    @Query(value =
            "SELECT * FROM product p, category c " +
            "WHERE p.category_id = c.id and p.name LIKE (%:query%)",
             countQuery = "SELECT count(*) FROM product " ,nativeQuery = true)
    Page<Product> getAllPagingAndSorting(Pageable pageable, @Param("query") String query);
    List<Product> findAllByCategory_Id(Integer id);

//    @Query(value =
//            "SELECT * FROM product p, category c " +
//                    "WHERE p.category_id = c.id and p.name LIKE (%:query%)", nativeQuery = true)
//    List<Product> getAll(@Param("query") String query);

}