package com.codecool.codecoolshopspring.model.category;

import com.codecool.codecoolshopspring.model.product.Product;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class Category {
    private int id;
    private String name;
    private String description;
    private String department;
    private List<Product> products;

    public Category(String name, String department, String description) {
        this.name = name;
        this.description = description;
        this.department = department;
        this.products = new ArrayList<>();
    }
}