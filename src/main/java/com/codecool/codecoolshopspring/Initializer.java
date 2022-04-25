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
        ProductCategory tablet = new ProductCategory("Tablet", "Hardware", "A tablet computer, commonly shortened to tablet, is a thin, flat mobile computer with a touchscreen display.");
        productCategoryRepository.save(tablet);

        //setting up products and printing it
        productRepository.save(new Product("Amazon Fire", new BigDecimal("49.9"), "USD", "Fantastic price. Large content ecosystem. Good parental controls. Helpful technical support.", tablet, amazon));
        productRepository.save(new Product("Lenovo IdeaPad Miix 700", new BigDecimal("479"), "USD", "Keyboard cover is included. Fanless Core m5 processor. Full-size USB ports. Adjustable kickstand.", tablet, lenovo));
        productRepository.save(new Product("Amazon Fire HD 8", new BigDecimal("89"), "USD", "Amazon's latest Fire HD 8 tablet is a great value for media consumption.", tablet, amazon));
    }
}
