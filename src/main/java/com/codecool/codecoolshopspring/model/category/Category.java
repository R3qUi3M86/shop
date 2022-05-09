package com.codecool.codecoolshopspring.model.category;

import com.codecool.codecoolshopspring.model.product.Product;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private String department;
    @OneToMany(mappedBy = "category")
    private List<Product> products;

    public Category(String name, String department, String description) {
        this.name = name;
        this.description = description;
        this.department = department;
        this.products = new ArrayList<>();
    }
}