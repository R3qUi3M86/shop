package com.codecool.codecoolshopspring.repository.implementation;

import com.codecool.codecoolshopspring.repository.SupplierRepository;
import com.codecool.codecoolshopspring.model.Supplier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class SupplierRepositoryMem implements SupplierRepository {

    private List<Supplier> data = new ArrayList<>();

    @Override
    public void save(Supplier supplier) {
        supplier.setId(data.size() + 1);
        data.add(supplier);
    }

    @Override
    public Optional<Supplier> findById(int id) {
        return data.stream().filter(t -> t.getId() == id).findFirst();
    }

    @Override
    public void deleteById(int id) {
        data.remove(findById(id));
    }

    @Override
    public List<Supplier> findAll() {
        return data;
    }
}
