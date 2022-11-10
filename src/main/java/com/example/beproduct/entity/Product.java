package com.example.beproduct.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 128, nullable = false)
    private String name;
    private float price;

    @Lob
    private String image;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

}
