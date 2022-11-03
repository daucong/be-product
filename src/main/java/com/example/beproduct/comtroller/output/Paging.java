package com.example.beproduct.comtroller.output;

import com.example.beproduct.entity.Product;
import lombok.Data;

import java.util.List;

@Data
public class Paging {
    private int currentPage;
    private int totalPage;
    private String sortname;
    private String sortby;
    private List<Product> listResult;
}
