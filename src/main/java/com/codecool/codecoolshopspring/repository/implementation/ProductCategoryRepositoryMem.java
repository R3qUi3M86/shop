package com.codecool.codecoolshopspring.repository.implementation;


import com.codecool.codecoolshopspring.repository.ProductCategoryRepository;
import com.codecool.codecoolshopspring.model.ProductCategory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ProductCategoryRepositoryMem implements ProductCategoryRepository {

    private List<ProductCategory> data = new ArrayList<>();

    @Override
    public void save(ProductCategory category) {
        category.setId(data.size() + 1);
        data.add(category);
    }

    @Override
    public Optional<ProductCategory> find(int id) {
        return data.stream().filter(t -> t.getId() == id).findFirst();
    }

    @Override
    public void deleteById(int id) {
        data.remove(find(id));
    }

    @Override
    public List<ProductCategory> findAll() {
        return data;
    }
}
