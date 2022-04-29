package com.codecool.codecoolshopspring;

import com.codecool.codecoolshopspring.repository.ProductCategoryRepository;
import com.codecool.codecoolshopspring.repository.ProductRepository;
import com.codecool.codecoolshopspring.repository.SupplierRepository;
import com.codecool.codecoolshopspring.model.Product;
import com.codecool.codecoolshopspring.model.ProductCategory;
import com.codecool.codecoolshopspring.model.Supplier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;

@Component
public class Initializer {

    private final ProductRepository productRepository;
    private final ProductCategoryRepository productCategoryRepository;
    private final SupplierRepository supplierRepository;

    public Initializer(ProductRepository productRepository, ProductCategoryRepository productCategoryRepository, SupplierRepository supplierRepository) {
        this.productRepository = productRepository;
        this.productCategoryRepository = productCategoryRepository;
        this.supplierRepository = supplierRepository;
    }

    @PostConstruct
    public void init() {
        //setting up a new supplier
        Supplier amazon = new Supplier("Amazon", "Digital content and services");
        supplierRepository.save(amazon);
        Supplier lenovo = new Supplier("Lenovo", "Computers");
        supplierRepository.save(lenovo);
        Supplier apple = new Supplier("Apple", "Steve Jobs is cool");
        supplierRepository.save(apple);

        //setting up a new product category
        ProductCategory tablets = new ProductCategory("Tablets", "Hardware", "A tablet computer, commonly shortened to tablet, is a thin, flat mobile computer with a touchscreen display.");
        ProductCategory laptops = new ProductCategory("Laptops", "Hardware", "A small, portable personal computer (PC) with a screen and alphanumeric keyboard.");
        ProductCategory smartphones = new ProductCategory("Smartphones", "Hardware", "A portable device that combines mobile telephone and computing functions into one unit.");
        productCategoryRepository.save(tablets);
        productCategoryRepository.save(laptops);
        productCategoryRepository.save(smartphones);

        //setting up products and printing it
        productRepository.save(new Product("Amazon Fire", new BigDecimal("49.9"), "USD", "Fantastic price. Large content ecosystem. Good parental controls. Helpful technical support.", tablets, amazon));
        productRepository.save(new Product("Lenovo IdeaPad Miix 700", new BigDecimal("479"), "USD", "Keyboard cover is included. Fanless Core m5 processor. Full-size USB ports. Adjustable kickstand.", tablets, lenovo));
        productRepository.save(new Product("Amazon Fire HD 8", new BigDecimal("89"), "USD", "Amazon's latest Fire HD 8 tablet is a great value for media consumption.", tablets, amazon));

        productRepository.save(new Product("Iphone 11", new BigDecimal("50.1"), "USD", "Cool Phone", smartphones, apple));
        productRepository.save(new Product("Iphone 11 Pro", new BigDecimal("455.1"), "USD", "Even Better", smartphones, apple));

        productRepository.save(new Product("MAC 11 Pro", new BigDecimal("0.1"), "USD", "Im cheap", laptops, apple));
        productRepository.save(new Product("DUPA", new BigDecimal("999"), "USD", "Js sucks", laptops, lenovo));
        productRepository.save(new Product("Pozdro600", new BigDecimal("111"), "USD", "wowr", laptops, amazon));
    }
}
