package com.codecool.codecoolshopspring.controller.rest;

import com.codecool.codecoolshopspring.model.supplier.SupplierDTO;
import com.codecool.codecoolshopspring.service.supplier.SupplierDTOService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class SupplierRestController {

    private final SupplierDTOService supplierDTOService;

    @GetMapping("/supplier/findAll")
    public List<SupplierDTO> getAllSupplierNames() {
        return supplierDTOService.getAll();
    }
}
