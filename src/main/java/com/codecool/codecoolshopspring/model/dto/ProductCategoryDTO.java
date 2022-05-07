package com.codecool.codecoolshopspring.model.dto;
import com.codecool.codecoolshopspring.model.ProductCategory;
import lombok.Getter;

@Getter
public class ProductCategoryDTO {
    private final int id;
    private final String name;
    private final String description;
    private final String department;

    public ProductCategoryDTO(ProductCategory productCategory){
        this.id = productCategory.getId();
        this.name = productCategory.getName();
        this.description = productCategory.getDescription();
        this.department = productCategory.getDepartment();
    }
}
