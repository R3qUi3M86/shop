package com.codecool.codecoolshopspring.service;

import com.codecool.codecoolshopspring.model.Product;
import com.codecool.codecoolshopspring.model.ProductCategory;
import com.codecool.codecoolshopspring.model.dto.ProductCategoryDTO;
import com.codecool.codecoolshopspring.model.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShopDTOService {
    private final ShopService shopService;


    public ShopDTOService(ShopService shopService){
        this.shopService = shopService;
    }

    public List<ProductDTO> getProductsDTOForCategory(int categoryId){
        List<Product> products = shopService.getProductsForCategory(categoryId);
        List<ProductDTO> prodDTOs = new ArrayList<>();
        products.forEach(e -> prodDTOs.add(new ProductDTO(e)));
        return prodDTOs;
    }

    public List<ProductCategoryDTO> getAllProductCategoriesDTO() {
        List<ProductCategory> productCategories = shopService.getAllProductCategories();
        List<ProductCategoryDTO> catDTOs = new ArrayList<>();
        productCategories.forEach(e -> catDTOs.add(new ProductCategoryDTO(e)));
        return catDTOs;
    }

    public List<ProductDTO> getAllProductsDTO() {
        List<Product> products = shopService.getAllProducts();
        List<ProductDTO> prodDTOs = new ArrayList<>();
        products.forEach(e -> prodDTOs.add(new ProductDTO(e)));
        return prodDTOs;
    }
}
