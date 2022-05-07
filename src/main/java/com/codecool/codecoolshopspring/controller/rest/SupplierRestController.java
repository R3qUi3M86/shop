package com.codecool.codecoolshopspring.controller.rest;

import com.codecool.codecoolshopspring.model.dto.SupplierDTO;
import com.codecool.codecoolshopspring.service.ShopService;
import com.codecool.codecoolshopspring.service.SupplierDTOService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SupplierRestController {

    private final ShopService shopService;
    private final SupplierDTOService supplierDTOService;

    public SupplierRestController(ShopService shopService, SupplierDTOService supplierDTOService) {
        this.shopService = shopService;
        this.supplierDTOService = supplierDTOService;
    }

    @GetMapping("/supplier/findAll")
    public List<SupplierDTO> getAllSupplierNames() {
        return supplierDTOService.getAll();
    }
}
