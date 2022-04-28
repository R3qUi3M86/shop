package com.codecool.codecoolshopspring.controller;

import com.codecool.codecoolshopspring.model.dto.ProductCategoryDTO;
import com.codecool.codecoolshopspring.model.dto.ProductDTO;
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

    @GetMapping("/category/findAll")
    public List<ProductCategoryDTO> getAllCategoryNames() {
        return serviceDTO.getAllProductCategoriesDTO();
    }

    @GetMapping("/product/findAll")
    public List<ProductDTO> getAllProductDTO() {
        return serviceDTO.getAllProductsDTO();
    }

    @PostMapping("/cart/addProduct")
    public Map<ProductDTO, Integer> addProductToCart(@RequestBody Map<String, Object> payload){
        String userName = (String) payload.get("userName");
        Integer prodId = (Integer) payload.get("productId");
        return service.addProductToOrder(userName, prodId);
    }
}
