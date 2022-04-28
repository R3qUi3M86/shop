package com.codecool.codecoolshopspring.controller;

import com.codecool.codecoolshopspring.model.dto.ProductCategoryDTO;
import com.codecool.codecoolshopspring.model.dto.ProductDTO;
import com.codecool.codecoolshopspring.service.ShopDTOService;
import com.codecool.codecoolshopspring.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // - using this makes controler not require @ResponseBody annotation in each function that returns JSON
public class ShopRestController {
    private final ShopService service;
    private final ShopDTOService serviceDTO;

    @Autowired
    public ShopRestController(ShopService service, ShopDTOService serviceDTO) {
        this.service = service;
        this.serviceDTO = serviceDTO;
    }

    @PostMapping("/display-products")
    public List<ProductDTO> getProductsByCategory(@RequestBody int categoryId) {
        return serviceDTO.getProductsDTOForCategory(categoryId);
    }

    @GetMapping("/get-categories")
    public List<ProductCategoryDTO> getAllCategoryNames() {
        return serviceDTO.getAllProductCategoriesDTO();
    }
}
