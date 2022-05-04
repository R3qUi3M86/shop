package com.codecool.codecoolshopspring.service;

import com.codecool.codecoolshopspring.model.Supplier;
import com.codecool.codecoolshopspring.model.dto.ProductCategoryDTO;
import com.codecool.codecoolshopspring.model.dto.SupplierDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SupplierDTOService {

    private final ShopService shopService;

    public SupplierDTOService(ShopService shopService) {
        this.shopService = shopService;
    }

    public List<SupplierDTO> getAll() {
        return shopService.getAllSuppliers().stream()
                .map(SupplierDTO::new)
                .collect(Collectors.toList());
    }
}
