package com.codecool.codecoolshopspring.model.product;

import com.codecool.codecoolshopspring.model.category.Category;
import com.codecool.codecoolshopspring.model.supplier.Supplier;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Currency;

@Data
public class Product{

    private int id;
    private String name;
    private String description;
    private final BigDecimal defaultPrice;
    private final Currency defaultCurrency;
    private final Category category;
    private final Supplier supplier;

    public Product(String name, BigDecimal defaultPrice, String currencyString, String description, Category category, Supplier supplier) {
        this.name = name;
        this.description = description;
        this.defaultPrice = defaultPrice;
        this.defaultCurrency = Currency.getInstance(currencyString);
        this.supplier = supplier;
        this.category = category;
    }
}
