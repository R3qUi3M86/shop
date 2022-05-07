package com.codecool.codecoolshopspring.controller.rest;

import com.codecool.codecoolshopspring.model.dto.ProductDTO;
import com.codecool.codecoolshopspring.service.ProductDTOService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ProductRestController {

    private final ProductDTOService productDTOService;

    @GetMapping("/product/filter")
    public List<ProductDTO> getProductsDTObyFilter(@RequestParam(defaultValue = "0") int supplierId, @RequestParam(defaultValue = "0") int categoryId) {
        return productDTOService.getProductsDTOForFilter(supplierId,categoryId);
    }
}
