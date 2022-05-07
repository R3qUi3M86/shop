package com.codecool.codecoolshopspring.service;

import com.codecool.codecoolshopspring.model.dto.SupplierDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class SupplierDTOService {

    private final ShopService shopService;

    public List<SupplierDTO> getAll() {
        return shopService.getAllSuppliers().stream()
                .map(SupplierDTO::new)
                .collect(Collectors.toList());
    }
}
