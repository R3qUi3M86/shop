package com.codecool.codecoolshopspring.service;

import com.codecool.codecoolshopspring.model.dto.ProductCategoryDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ProductCategoryDTOService {

    private final ShopService shopService;

    public List<ProductCategoryDTO> getAll() {
        return shopService.getAllProductCategories().stream()
                .map(ProductCategoryDTO::new)
                .collect(Collectors.toList());
    }
}
