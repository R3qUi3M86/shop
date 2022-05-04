package com.codecool.codecoolshopspring.service;


import com.codecool.codecoolshopspring.model.Product;
import com.codecool.codecoolshopspring.model.dto.ProductDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ProductDTOService {
    private final ShopService shopService;

    public ProductDTOService(ShopService shopService) {
        this.shopService = shopService;
    }

    public List<ProductDTO> getProductsDTOForFilter(int supplierId, int categoryId) {
            return shopService.getAllProducts().stream()
                    .filter(e -> supplierId == 0 || e.getSupplier().equals(shopService.getSupplier(supplierId)))
                    .filter(e -> categoryId == 0 || e.getProductCategory().equals(shopService.getProductCategory(categoryId)))
                    .map(ProductDTO::new)
                    .collect(Collectors.toList());
    }

    public List<ProductDTO> getProductsDTOList(Set<Product> productSet){
        return productSet.stream().map(ProductDTO::new).collect(Collectors.toList());
    }
}
