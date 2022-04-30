package com.codecool.codecoolshopspring.controller;

import com.codecool.codecoolshopspring.model.dto.ProductCategoryDTO;
import com.codecool.codecoolshopspring.model.dto.ProductDTO;
import com.codecool.codecoolshopspring.model.dto.SupplierDTO;
import com.codecool.codecoolshopspring.service.ShopDTOService;
import com.codecool.codecoolshopspring.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController // - using this makes controler not require @ResponseBody annotation in each function that returns JSON
public class ShopRestController {
    private final ShopService service;
    private final ShopDTOService serviceDTO;

    @Autowired
    public ShopRestController(ShopService service, ShopDTOService serviceDTO) {
        this.service = service;
        this.serviceDTO = serviceDTO;
    }

    @PostMapping("/product/findByCategory")
    public List<ProductDTO> getProductsByCategory(@RequestBody int categoryId) {
        return serviceDTO.getProductsDTOForCategory(categoryId);
    }
    @PostMapping("/product/findBySupplier")
    public List<ProductDTO> getProductsBySupplier(@RequestBody int supplierId) {
        return serviceDTO.getProductsDTOForSupplier(supplierId);
    }
    @PostMapping("/product/findByCustomFilter")
    public List<ProductDTO> getProductsBySupplier(@RequestBody Map<String, Integer> filterOptions) {

        return serviceDTO.getProductsDTOForFilter(filterOptions.get("supplierId"),filterOptions.get("categoryId"));
    }


    @GetMapping("/category/findAll")
    public List<ProductCategoryDTO> getAllCategoryNames() {
        return serviceDTO.getAllProductCategoriesDTO();
    }@GetMapping("/supplier/findAll")
    public List<SupplierDTO> getAllSupplierNames() {
        return serviceDTO.getAllProductSuppliersDTO();
    }



    @GetMapping("/product/findAll")
    public List<ProductDTO> getAllProductDTO() {
        return serviceDTO.getAllProductsDTO();
    }

    @PostMapping("/cart/addProduct")
    public Map<String, Integer> addProductToCart(@RequestBody Map<String, Object> payload){
        String userName = (String) payload.get("userName");
        Integer prodId = Integer.parseInt((String) payload.get("productId"));
        return service.addProductToOrder(userName, prodId);
    }
}
