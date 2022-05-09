package com.codecool.codecoolshopspring.model.product;

import com.codecool.codecoolshopspring.model.category.Category;
import com.codecool.codecoolshopspring.model.supplier.Supplier;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.Objects;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Product{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private BigDecimal defaultPrice;
    private Currency defaultCurrency;
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;
    @ManyToOne
    @JoinColumn(name = "supplier_id", nullable = false)
    private Supplier supplier;

    public Product(String name, BigDecimal defaultPrice, String currencyString, String description, Category category, Supplier supplier) {
        this.name = name;
        this.description = description;
        this.defaultPrice = defaultPrice;
        this.defaultCurrency = Currency.getInstance(currencyString);
        this.supplier = supplier;
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
