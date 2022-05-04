package com.codecool.codecoolshopspring.service;


import com.codecool.codecoolshopspring.model.dto.ProductDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductDTOService {
    private final ShopService shopService;

    public ProductDTOService(ShopService shopService) {
        this.shopService = shopService;
    }

    public List<ProductDTO> getProductsDTOForFilter(int supplierId, int categoryId) {
        if (supplierId == 0 && categoryId == 0) {
            return shopService.getAllProducts().stream()
                    .map(ProductDTO::new)
                    .collect(Collectors.toList());
        } else if (supplierId == 0 && categoryId > 0) {
            return shopService.getAllProducts().stream()
                    .filter(e -> e.getProductCategory().equals(shopService.getProductCategory(categoryId)))
                    .map(ProductDTO::new)
                    .collect(Collectors.toList());
        } else if (supplierId > 0 && categoryId == 0) {
            return shopService.getAllProducts().stream()
                    .filter(e -> e.getSupplier().equals(shopService.getSupplier(supplierId)))
                    .map(ProductDTO::new)
                    .collect(Collectors.toList());
        } else {
            return shopService.getAllProducts().stream()
                    .filter(e -> e.getSupplier().equals(shopService.getSupplier(supplierId)))
                    .filter(e -> e.getProductCategory().equals(shopService.getProductCategory(categoryId)))
                    .map(ProductDTO::new)
                    .collect(Collectors.toList());
        }
    }
}
