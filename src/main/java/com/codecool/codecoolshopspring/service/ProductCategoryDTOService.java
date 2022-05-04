package com.codecool.codecoolshopspring.service;

import com.codecool.codecoolshopspring.model.dto.ProductCategoryDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductCategoryDTOService {

    private final ShopService shopService;

    public ProductCategoryDTOService(ShopService shopService) {
        this.shopService = shopService;
    }

    public List<ProductCategoryDTO> getAll() {
        return shopService.getAllProductCategories().stream()
                .map(ProductCategoryDTO::new)
                .collect(Collectors.toList());
    }
}
