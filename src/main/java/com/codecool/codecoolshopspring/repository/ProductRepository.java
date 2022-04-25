package com.codecool.codecoolshopspring.repository;

import com.codecool.codecoolshopspring.model.Product;
import com.codecool.codecoolshopspring.model.ProductCategory;
import com.codecool.codecoolshopspring.model.Supplier;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    List<Product> findAll();
    Optional<Product> findById(int id);
    List<Product> findAllBySupplier(Supplier supplier);
    List<Product> findAllByProductCategory(ProductCategory productCategory);

    void save(Product product);
    void deleteById(int id);

}
