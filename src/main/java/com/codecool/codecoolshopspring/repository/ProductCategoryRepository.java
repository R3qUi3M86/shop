package com.codecool.codecoolshopspring.repository;

import com.codecool.codecoolshopspring.model.ProductCategory;

import java.util.List;
import java.util.Optional;

public interface ProductCategoryRepository {

    List<ProductCategory> findAll();
    Optional<ProductCategory> find(int id);

    void save(ProductCategory category);
    void deleteById(int id);

}
