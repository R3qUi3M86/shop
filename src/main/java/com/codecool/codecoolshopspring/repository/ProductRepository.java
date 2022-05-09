package com.codecool.codecoolshopspring.repository;

import com.codecool.codecoolshopspring.model.product.Product;
import com.codecool.codecoolshopspring.model.category.Category;
import com.codecool.codecoolshopspring.model.supplier.Supplier;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    List<Product> findAll();
    Optional<Product> findById(int id);
    List<Product> findAllBySupplier(Supplier supplier);
    List<Product> findAllByProductCategory(Category category);

    void save(Product product);
    void deleteById(int id);

}
