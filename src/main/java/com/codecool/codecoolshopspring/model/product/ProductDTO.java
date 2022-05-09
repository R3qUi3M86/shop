package com.codecool.codecoolshopspring.model.product;

import com.codecool.codecoolshopspring.model.product.Product;
import lombok.Getter;

import java.util.Currency;

@Getter
public class ProductDTO {
    private final int id;
    private final String name;
    private final String description;
    private final String defaultPrice;
    private final Currency defaultCurrency;
    private final String productCategory;
    private final String supplier;

    public ProductDTO(Product product){
        this.id = product.getId();
        this.name = product.getName();
        this.description = product.getDescription();
        this.defaultPrice = product.getDefaultPrice().toPlainString();
        this.defaultCurrency = product.getDefaultCurrency();
        this.productCategory = product.getCategory().getName();
        this.supplier = product.getSupplier().getName();
    }
}
