package com.codecool.codecoolshopspring.model.dto;

import com.codecool.codecoolshopspring.model.Product;
import com.codecool.codecoolshopspring.model.Supplier;

import java.util.ArrayList;
import java.util.List;

public class SupplierDTO {
    protected int id;
    protected String name;
    protected String description;

    public SupplierDTO(Supplier supplier){
        this.id = supplier.getId();
        this.name = supplier.getName();
        this.description = supplier.getDescription();
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
}
