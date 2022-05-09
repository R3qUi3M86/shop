package com.codecool.codecoolshopspring.model.category;
import lombok.Getter;

@Getter
public class CategoryDTO {
    private final int id;
    private final String name;
    private final String description;
    private final String department;

    public CategoryDTO(Category category){
        this.id = category.getId();
        this.name = category.getName();
        this.description = category.getDescription();
        this.department = category.getDepartment();
    }
}
