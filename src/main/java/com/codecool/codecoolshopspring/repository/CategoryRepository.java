package com.codecool.codecoolshopspring.repository;

import com.codecool.codecoolshopspring.model.category.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
