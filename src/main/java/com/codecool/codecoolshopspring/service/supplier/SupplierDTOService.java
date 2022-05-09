package com.codecool.codecoolshopspring.service.supplier;

import com.codecool.codecoolshopspring.model.supplier.SupplierDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class SupplierDTOService {

    private final SupplierService supplierService;

    public List<SupplierDTO> getAll() {
        return supplierService.getAllSuppliers().stream()
                .map(SupplierDTO::new)
                .collect(Collectors.toList());
    }
}
