package com.codecool.codecoolshopspring.service.supplier;

import com.codecool.codecoolshopspring.model.supplier.Supplier;
import com.codecool.codecoolshopspring.repository.SupplierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SupplierService {

    private final SupplierRepository supplierRepository;

    public List<Supplier> getAllSuppliers() {
        return supplierRepository.findAll();
    }

    public Supplier getSupplier(int supplierId){
        return supplierRepository.findById(supplierId).orElseThrow();
    }
}
