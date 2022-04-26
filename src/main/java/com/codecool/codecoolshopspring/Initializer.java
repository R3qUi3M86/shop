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
    }
}
