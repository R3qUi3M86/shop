package com.codecool.codecoolshopspring.repository.implementation;


import com.codecool.codecoolshopspring.repository.ProductRepository;
import com.codecool.codecoolshopspring.model.Product;
import com.codecool.codecoolshopspring.model.ProductCategory;
import com.codecool.codecoolshopspring.model.Supplier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ProductRepositoryMem implements ProductRepository {

    private List<Product> data = new ArrayList<>();

    @Override
    public void save(Product product) {
        product.setId(data.size() + 1);
        data.add(product);
    }

    @Override
    public Optional<Product> findById(int id) {
        return data.stream().filter(t -> t.getId() == id).findFirst();
    }

    @Override
    public void deleteById(int id) {
        data.remove(findById(id));
    }

    @Override
    public List<Product> findAll() {
        return data;
    }

    @Override
    public List<Product> findAllBySupplier(Supplier supplier) {
        return data.stream().filter(t -> t.getSupplier().equals(supplier)).collect(Collectors.toList());
    }

    @Override
    public List<Product> findAllByProductCategory(ProductCategory productCategory) {
        return data.stream().filter(t -> t.getProductCategory().equals(productCategory)).collect(Collectors.toList());
    }
}
