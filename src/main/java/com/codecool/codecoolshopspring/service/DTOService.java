package com.codecool.codecoolshopspring.service;

import org.springframework.stereotype.Service;

@Service
public class DTOService {
    private final ProductDTOService productDTOService;
    private final SupplierDTOService supplierDTOService;
    private final ProductCategoryDTOService productCategoryDTOService;


    public DTOService(ProductDTOService productDTOService, SupplierDTOService supplierDTOService, ProductCategoryDTOService productCategoryDTOService){
        this.productDTOService = productDTOService;
        this.supplierDTOService = supplierDTOService;
        this.productCategoryDTOService = productCategoryDTOService;
    }

    public ProductDTOService getProductDTOService() {
        return productDTOService;
    }

    public SupplierDTOService getSupplierDTOService() {
        return supplierDTOService;
    }

    public ProductCategoryDTOService getProductCategoryDTOService() {
        return productCategoryDTOService;
    }
}
