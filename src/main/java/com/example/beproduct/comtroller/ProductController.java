package com.example.beproduct.comtroller;

import com.example.beproduct.entity.Product;
import com.example.beproduct.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
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
    public Page<Product> pagingProduct(@RequestParam("page") int currentPage,
                                       @RequestParam("limit") int limit,
                                       @RequestParam("sortname") String sortName,
                                       @RequestParam("sortby") String sortBy) {
        Sort sort = Sort.by(Sort.Direction.fromString(sortName), sortBy);
        Pageable pageable = PageRequest.of(currentPage - 1, limit, sort);
        return productService.getAllPagingAndSorting(pageable);
    }

    @DeleteMapping("/{id}")
    public void DeleteProduct(@PathVariable("id") Integer id) {
        productService.delete(id);
    }

//    @GetMapping("")
//    public Paging pagingProduct(@RequestParam("page") int currentPage,
//                                @RequestParam("limit") int limit,
//                                @RequestParam("sortname") String sortName,
//                                @RequestParam("sortby") String sortBy) {
//        Paging result = new Paging();
//        result.setCurrentPage(currentPage);
//        //currentPage - 1 vì nó bđ từ phần tử thứ 0 nhưng ta chạy từ 1 nên phải trừ đi 1
//        result.setListResult(productService.getProductByPage(PageRequest.of(currentPage - 1,limit,Sort.by(Sort.Direction.fromString(sortName), sortBy))));
//        result.setSortname(sortName);
//        result.setSortby(sortBy);
//        double kq = productService.totalItem() % limit;
//        if (kq != 0){
//            result.setTotalPage((int) (Math.ceil((productService.totalItem()) / limit) + 1));
//        }else {
//            result.setTotalPage((int) Math.ceil((productService.totalItem()) / limit));
//        }
//        return result;
//    }
}
