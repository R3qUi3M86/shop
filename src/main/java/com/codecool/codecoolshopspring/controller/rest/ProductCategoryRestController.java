package com.codecool.codecoolshopspring.controller.rest;

import com.codecool.codecoolshopspring.model.dto.ProductCategoryDTO;
import com.codecool.codecoolshopspring.service.ProductCategoryDTOService;
import com.codecool.codecoolshopspring.service.ShopService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductCategoryRestController {

    private final ShopService shopService;
    private final ProductCategoryDTOService productCategoryDTOService;

    public ProductCategoryRestController(ShopService shopService, ProductCategoryDTOService productCategoryDTOService) {
        this.shopService = shopService;
        this.productCategoryDTOService = productCategoryDTOService;
    }

    @GetMapping("/category/findAll")
    public List<ProductCategoryDTO> getAllCategoryNames() {
        return productCategoryDTOService.getAll();
    }
}
