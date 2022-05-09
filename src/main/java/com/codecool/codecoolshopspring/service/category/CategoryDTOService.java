package com.codecool.codecoolshopspring.service.category;

import com.codecool.codecoolshopspring.model.category.CategoryDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CategoryDTOService {

    private final CategoryService categoryService;

    public List<CategoryDTO> getAll() {
        return categoryService.getAllProductCategories().stream()
                .map(CategoryDTO::new)
                .collect(Collectors.toList());
    }
}
