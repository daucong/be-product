package com.example.beproduct.comtroller;

import com.example.beproduct.entity.Product;
import com.example.beproduct.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private BaseService<Product> productService;

    @PostMapping("")
    public void saveProduct(@RequestBody Product product) {
        productService.saveOrUpdate(product);
    }

    @GetMapping("/{id}")
    public Product findProductById(@PathVariable("id") Integer id) {
        return productService.getOneById(id);
    }

    @GetMapping("")
    public Page<Product> pagingAndSearchProduct(@RequestParam("page") int currentPage,
                                       @RequestParam("limit") int limit,
                                       @RequestParam("sortname") String sortName,
                                       @RequestParam("sortby") String sortBy,
                                       @RequestParam("query") String query) {
        Sort sort = Sort.by(Sort.Direction.fromString(sortName), sortBy);
        Pageable pageable = PageRequest.of(currentPage - 1, limit, sort);
        return productService.getAllPagingAndSorting(pageable,query);
    }

    @DeleteMapping("/{id}")
    public void DeleteProduct(@PathVariable("id") Integer id) {
        productService.delete(id);
    }
}
