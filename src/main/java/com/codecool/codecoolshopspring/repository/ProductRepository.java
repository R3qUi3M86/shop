package com.codecool.codecoolshopspring.repository;

import com.codecool.codecoolshopspring.model.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
