package com.codecool.codecoolshopspring.model.supplier;

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
public class Supplier{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    @OneToMany(mappedBy = "supplier")
    private List<Product> products;

    public Supplier(String name, String description) {
        this.name = name;
        this.description = description;
        this.products = new ArrayList<>();
    }
}