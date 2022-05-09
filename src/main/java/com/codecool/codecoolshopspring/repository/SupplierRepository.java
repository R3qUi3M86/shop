package com.codecool.codecoolshopspring.repository;

import com.codecool.codecoolshopspring.model.category.Category;
import com.codecool.codecoolshopspring.model.supplier.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SupplierRepository extends JpaRepository<Supplier, Integer> {

//    List<Supplier> findAll();
//    Optional<Supplier> findById(int id);
//
//    void save(Supplier supplier);
//    void deleteById(int id);

}
