package com.codecool.codecoolshopspring.model.pojo;

import com.codecool.codecoolshopspring.model.Product;
import com.codecool.codecoolshopspring.model.ProductCategory;

import java.util.ArrayList;
import java.util.List;

public class ProductCategoryDTO {
    protected int id;
    protected String name;
    protected String description;
    private String department;
    private List<ProductDTO> products = new ArrayList<>();

    public ProductCategoryDTO(ProductCategory productCategory){
        this.id = productCategory.getId();
        this.name = productCategory.getName();
        this.description = productCategory.getDescription();
        this.department = productCategory.getDepartment();
        for(Product product : productCategory.getProducts()){
            products.add(new ProductDTO(product));
        }
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getDepartment() {
        return department;
    }

    public List<ProductDTO> getProducts() {
        return products;
    }
}
