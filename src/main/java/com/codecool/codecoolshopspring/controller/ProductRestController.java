package com.codecool.codecoolshopspring.controller;

import com.codecool.codecoolshopspring.model.dto.ProductDTO;
import com.codecool.codecoolshopspring.service.ProductDTOService;
import com.codecool.codecoolshopspring.service.ShopService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductRestController {

    private final ShopService shopService;
    private final ProductDTOService productDTOService;

    public ProductRestController(ShopService shopService, ProductDTOService productDTOService) {
        this.shopService = shopService;
        this.productDTOService = productDTOService;
    }

    @GetMapping("/product/filter")
    public List<ProductDTO> getProductsDTObyFilter(@RequestParam(defaultValue = "0") int supplierId, @RequestParam(defaultValue = "0") int categoryId) {
        return productDTOService.getProductsDTOForFilter(supplierId,categoryId);
    }
}
