package com.example.beproduct.comtroller.output;

import com.example.beproduct.entity.Product;
import lombok.Data;

import java.util.List;

@Data
public class Paging {
    private int page;
    private double totalPage;
    private List<Product> listResult;
}
