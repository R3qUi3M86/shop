package com.codecool.codecoolshopspring.service;

import com.codecool.codecoolshopspring.model.Product;
import com.codecool.codecoolshopspring.model.ProductCategory;
import com.codecool.codecoolshopspring.model.Supplier;
import com.codecool.codecoolshopspring.model.dto.ProductCategoryDTO;
import com.codecool.codecoolshopspring.model.dto.ProductDTO;
import com.codecool.codecoolshopspring.model.dto.SupplierDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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

    public List<ProductDTO> getProductsDTOForSupplier(int supplierId) {
        List<Product> products = shopService.getProductsForSupplier(supplierId);
        List<ProductDTO> prodDTOs = new ArrayList<>();
        products.forEach(e -> prodDTOs.add(new ProductDTO(e)));
        return prodDTOs;
    }

    public List<SupplierDTO> getAllProductSuppliersDTO() {
        List<Supplier> suppliers = shopService.getAllSuppliers();
        List<SupplierDTO> supDTOs = new ArrayList<>();
        suppliers.forEach(e -> supDTOs.add(new SupplierDTO(e)));
        return supDTOs;
    }

    public List<ProductDTO> getProductsDTOForFilter(int supplierId, int categoryId) {
        List<Product> products = shopService.getAllProducts();
        ProductCategory productCategory = shopService.getProductCategory(categoryId);
        Supplier supplier = shopService.getSupplier(supplierId);
        List<ProductDTO> prodDTOs = new ArrayList<>();
        products.stream()
                .filter(e -> e.getSupplier().equals(supplier) && e.getProductCategory().equals(productCategory))
                .forEach(e -> prodDTOs.add(new ProductDTO(e)));
        return prodDTOs;
    }

    public List<ProductDTO> getProductsDTOList(Set<Product> productSet){
        return productSet.stream().map(ProductDTO::new).collect(Collectors.toList());
    }
}
