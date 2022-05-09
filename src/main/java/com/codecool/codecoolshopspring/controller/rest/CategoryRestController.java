package com.codecool.codecoolshopspring.controller.rest;

import com.codecool.codecoolshopspring.model.category.CategoryDTO;
import com.codecool.codecoolshopspring.service.category.CategoryDTOService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CategoryRestController {

    private final CategoryDTOService categoryDTOService;

    @GetMapping("/category/findAll")
    public List<CategoryDTO> getAllCategoryNames() {
        return categoryDTOService.getAll();
    }
}
