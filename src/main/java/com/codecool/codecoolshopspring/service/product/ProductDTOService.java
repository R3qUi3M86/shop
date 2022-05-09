package com.codecool.codecoolshopspring.service.product;

import com.codecool.codecoolshopspring.model.product.Product;
import com.codecool.codecoolshopspring.model.product.ProductDTO;
import com.codecool.codecoolshopspring.service.category.CategoryService;
import com.codecool.codecoolshopspring.service.supplier.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ProductDTOService {
    private final CategoryService categoryService;
    private final SupplierService supplierService;
    private final ProductService productService;

    public List<ProductDTO> getProductsDTOForFilter(int supplierId, int categoryId) {
            return productService.getAllProducts().stream()
                    .filter(e -> supplierId == 0 || e.getSupplier().equals(supplierService.getSupplier(supplierId)))
                    .filter(e -> categoryId == 0 || e.getCategory().equals(categoryService.getProductCategory(categoryId)))
                    .map(ProductDTO::new)
                    .collect(Collectors.toList());
    }

    public List<ProductDTO> getProductsDTOList(Set<Product> productSet){
        return productSet.stream().map(ProductDTO::new).collect(Collectors.toList());
    }
}
