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
    public Paging pagingProduct(@RequestParam("page") int currentPage,
                                @RequestParam("limit") int limit,
                                @RequestParam("sortname") String sortName,
                                @RequestParam("sortby") String sortBy) {
        Paging result = new Paging();
        result.setCurrentPage(currentPage);
        //currentPage - 1 vì nó bđ từ phần tử thứ 0 nhưng ta chạy từ 1 nên phải trừ đi 1
        result.setListResult(productService.getProductByPage(PageRequest.of(currentPage - 1,limit,Sort.by(Sort.Direction.fromString(sortName), sortBy))));
        result.setSortname(sortName);
        result.setSortby(sortBy);
        double kq = productService.totalItem() % limit;
        if (kq != 0){
            result.setTotalPage((int) (Math.ceil((productService.totalItem()) / limit) + 1));
        }else {
            result.setTotalPage((int) Math.ceil((productService.totalItem()) / limit));
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
