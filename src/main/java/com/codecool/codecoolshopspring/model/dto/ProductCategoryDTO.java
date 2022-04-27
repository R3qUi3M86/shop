package com.codecool.codecoolshopspring.model.dto;
import com.codecool.codecoolshopspring.model.ProductCategory;

public class ProductCategoryDTO {
    protected int id;
    protected String name;
    protected String description;
    private String department;

    public ProductCategoryDTO(ProductCategory productCategory){
        this.id = productCategory.getId();
        this.name = productCategory.getName();
        this.description = productCategory.getDescription();
        this.department = productCategory.getDepartment();
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
}
