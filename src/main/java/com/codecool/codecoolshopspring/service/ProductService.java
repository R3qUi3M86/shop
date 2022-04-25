package com.codecool.codecoolshopspring.service;

import com.codecool.codecoolshopspring.repository.ProductCategoryRepository;
import com.codecool.codecoolshopspring.repository.ProductRepository;
import com.codecool.codecoolshopspring.model.Product;
import com.codecool.codecoolshopspring.model.ProductCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService{
    private ProductRepository productRepository;
    private ProductCategoryRepository productCategoryRepository;

    @Autowired
    public ProductService(ProductRepository productRepository, ProductCategoryRepository productCategoryRepository) {
        this.productRepository = productRepository;
        this.productCategoryRepository = productCategoryRepository;
    }

    public ProductCategory getProductCategory(int categoryId){
        return productCategoryRepository.find(categoryId).orElseThrow();
    }

    public List<Product> getProductsForCategory(int categoryId){
        ProductCategory category = productCategoryRepository.find(categoryId).orElseThrow();
        return productRepository.findAllByProductCategory(category);
    }


}
