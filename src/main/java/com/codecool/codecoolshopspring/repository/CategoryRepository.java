package com.codecool.codecoolshopspring.repository;

import com.codecool.codecoolshopspring.model.category.Category;
import com.codecool.codecoolshopspring.model.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

//    List<Category> findAll();
//    Optional<Category> find(int id);
//
//    void save(Category category);
//    void deleteById(int id);

}
