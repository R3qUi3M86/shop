package com.codecool.codecoolshopspring.repository;

import com.codecool.codecoolshopspring.model.category.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository {

    List<Category> findAll();
    Optional<Category> find(int id);

    void save(Category category);
    void deleteById(int id);

}
