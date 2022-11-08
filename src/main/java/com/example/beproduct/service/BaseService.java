package com.example.beproduct.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BaseService<T> {
    Page<T> getAllPagingAndSorting(Pageable pageable);

    List<T> getAlllist();

    T getOneById(Integer id);

    T saveOrUpdate(T entity);

    boolean delete(Integer id);
}
