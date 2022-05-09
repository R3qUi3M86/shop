package com.codecool.codecoolshopspring.repository;

import com.codecool.codecoolshopspring.model.supplier.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier, Integer> {
}
