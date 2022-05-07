package com.codecool.codecoolshopspring.model.dto;

import com.codecool.codecoolshopspring.model.Supplier;
import lombok.Getter;

@Getter
public class SupplierDTO {
    private final int id;
    private final String name;
    private final String description;

    public SupplierDTO(Supplier supplier){
        this.id = supplier.getId();
        this.name = supplier.getName();
        this.description = supplier.getDescription();
    }
}
