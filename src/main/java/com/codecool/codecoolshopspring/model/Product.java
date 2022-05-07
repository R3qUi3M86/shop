package com.codecool.codecoolshopspring.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Currency;

@Data
public class Product extends BaseModel {

    private final BigDecimal defaultPrice;
    private final Currency defaultCurrency;
    private final ProductCategory productCategory;
    private final Supplier supplier;

    public Product(String name, BigDecimal defaultPrice, String currencyString, String description, ProductCategory productCategory, Supplier supplier) {
        super(name, description);
        this.defaultPrice = defaultPrice;
        this.defaultCurrency = Currency.getInstance(currencyString);
        this.supplier = supplier;
        this.productCategory = productCategory;
    }
}
