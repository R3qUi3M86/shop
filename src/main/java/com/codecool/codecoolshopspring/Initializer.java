package com.codecool.codecoolshopspring;

import com.codecool.codecoolshopspring.model.category.Category;
import com.codecool.codecoolshopspring.repository.CategoryRepository;
import com.codecool.codecoolshopspring.repository.ProductRepository;
import com.codecool.codecoolshopspring.repository.SupplierRepository;
import com.codecool.codecoolshopspring.model.product.Product;
import com.codecool.codecoolshopspring.model.supplier.Supplier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;

@Component
public class Initializer {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final SupplierRepository supplierRepository;

    public Initializer(ProductRepository productRepository, CategoryRepository categoryRepository, SupplierRepository supplierRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
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
        Category tablets = new Category("Tablets", "Hardware", "A tablet computer, commonly shortened to tablet, is a thin, flat mobile computer with a touchscreen display.");
        Category laptops = new Category("Laptops", "Hardware", "A small, portable personal computer (PC) with a screen and alphanumeric keyboard.");
        Category smartphones = new Category("Smartphones", "Hardware", "A portable device that combines mobile telephone and computing functions into one unit.");
        categoryRepository.save(tablets);
        categoryRepository.save(laptops);
        categoryRepository.save(smartphones);

        //setting up products and printing it
        productRepository.save(new Product("Amazon Fire", new BigDecimal("49.90"), "USD", "Fantastic price. Large content ecosystem. Good parental controls. Helpful technical support.", tablets, amazon));
        productRepository.save(new Product("Lenovo IdeaPad Miix 700", new BigDecimal("479.00"), "USD", "Keyboard cover is included. Fanless Core m5 processor. Full-size USB ports. Adjustable kickstand.", tablets, lenovo));
        productRepository.save(new Product("Amazon Fire HD 8", new BigDecimal("89.00"), "USD", "Amazon's latest Fire HD 8 tablet is a great value for media consumption.", tablets, amazon));

        productRepository.save(new Product("Iphone 11", new BigDecimal("50.10"), "USD", "Cool Phone", smartphones, apple));
        productRepository.save(new Product("Iphone 11 Pro", new BigDecimal("455.10"), "USD", "Even Better", smartphones, apple));

        productRepository.save(new Product("MAC 13", new BigDecimal("0.10"), "USD", "Im cheap", laptops, apple));
        productRepository.save(new Product("Laptop Lenovo IdeaPad", new BigDecimal("999.99"), "USD", "worth it", laptops, lenovo));
        productRepository.save(new Product("Amazon Laptop", new BigDecimal("111.00"), "USD", "wowr", laptops, amazon));
        productRepository.save(new Product("Amazon Phone", new BigDecimal("456.10"), "USD", "Even Better", smartphones, amazon));
    }
}
