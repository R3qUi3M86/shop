package com.codecool.codecoolshopspring.service.category;

import com.codecool.codecoolshopspring.model.category.Category;
import com.codecool.codecoolshopspring.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<Category> getAllProductCategories() {
        return categoryRepository.findAll();
    }

    public Category getProductCategory(int categoryId){
        return categoryRepository.find(categoryId).orElseThrow();
    }
}
