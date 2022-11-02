package com.example.beproduct.comtroller;

import com.example.beproduct.comtroller.output.Paging;
import com.example.beproduct.entity.Product;
import com.example.beproduct.service.CategoryService;
import com.example.beproduct.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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

    @GetMapping("/api/products/paging")
    public Paging pagingProduct(@RequestParam("page") int page,
                              @RequestParam("limit") int limit) {
        Paging result = new Paging();
        result.setPage(page);
        result.setListResult(productService.getProductByPage(PageRequest.of(page-1,limit, Sort.by(Sort.Direction.ASC, "id"))));
        double kq = productService.totalItem() % limit;
        if (kq != 0){
            result.setTotalPage(Math.ceil((productService.totalItem()) / limit) + 1);
        }else {
            result.setTotalPage(Math.ceil((productService.totalItem()) / limit));
        }
        return result;
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
    public Product findProductById(@PathVariable("id") Integer id) {
        return productService.findProductById(id);
    }


}
