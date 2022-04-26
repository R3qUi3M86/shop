package com.codecool.codecoolshopspring.model.dto;

import com.codecool.codecoolshopspring.model.Product;

import java.math.BigDecimal;
import java.util.Currency;

public class ProductDTO {
    protected int id;
    protected String name;
    protected String description;
    private BigDecimal defaultPrice;
    private Currency defaultCurrency;
    private String productCategory;
    private String supplier;

    public ProductDTO(Product product){
        this.id = product.getId();
        this.name = product.getName();
        this.description = product.getDescription();
        this.defaultPrice = product.getDefaultPrice();
        this.defaultCurrency = product.getDefaultCurrency();
        this.productCategory = product.getProductCategory().getName();
        this.supplier = product.getSupplier().getName();
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

    public BigDecimal getDefaultPrice() {
        return defaultPrice;
    }

    public Currency getDefaultCurrency() {
        return defaultCurrency;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public String getSupplier() {
        return supplier;
    }
}
