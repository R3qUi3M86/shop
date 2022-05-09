package com.codecool.codecoolshopspring.repository;

import com.codecool.codecoolshopspring.model.supplier.Supplier;

import java.util.List;
import java.util.Optional;

public interface SupplierRepository {

    List<Supplier> findAll();
    Optional<Supplier> findById(int id);

    void save(Supplier supplier);
    void deleteById(int id);

}
