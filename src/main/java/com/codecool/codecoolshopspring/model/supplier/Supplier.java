package com.codecool.codecoolshopspring.model.supplier;

import com.codecool.codecoolshopspring.model.product.Product;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class Supplier{
    private int id;
    private String name;
    private String description;
    private List<Product> products;

    public Supplier(String name, String description) {
        this.name = name;
        this.description = description;
        this.products = new ArrayList<>();
    }
}