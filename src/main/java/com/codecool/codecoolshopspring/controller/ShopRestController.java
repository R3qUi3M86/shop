package com.codecool.codecoolshopspring.controller;

import com.codecool.codecoolshopspring.model.dto.ProductCategoryDTO;
import com.codecool.codecoolshopspring.model.dto.ProductDTO;
import com.codecool.codecoolshopspring.model.dto.SupplierDTO;
import com.codecool.codecoolshopspring.service.DTOService;
import com.codecool.codecoolshopspring.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController // - using this makes controler not require @ResponseBody annotation in each function that returns JSON
public class ShopRestController {
    private final ShopService service;
    private final DTOService serviceDTO;

    @Autowired
    public ShopRestController(ShopService service, DTOService serviceDTO) {
        this.service = service;
        this.serviceDTO = serviceDTO;
    }

    @GetMapping("/product/filter")
    public List<ProductDTO> getProductsDTObyFilter(@RequestParam(defaultValue = "0") int supplierId, @RequestParam(defaultValue = "0") int categoryId) {
        return serviceDTO.getProductDTOService().getProductsDTOForFilter(supplierId,categoryId);
    }

    @GetMapping("/category/findAll")
    public List<ProductCategoryDTO> getAllCategoryNames() {
        return serviceDTO.getProductCategoryDTOService().getAll();

    }@GetMapping("/supplier/findAll")
    public List<SupplierDTO> getAllSupplierNames() {
        return serviceDTO.getSupplierDTOService().getAll();
    }

    @PostMapping("/cart/addProduct")
    public Map<String, Integer> addProductToCart(@RequestBody Map<String, Object> payload){
        String userName = (String) payload.get("userName");
        Integer prodId = Integer.parseInt((String) payload.get("productId"));
        return service.addProductToOrder(userName, prodId);
    }
}
