//package com.codecool.codecoolshopspring.controller;
//
//import com.codecool.codecoolshopspring.model.pojo.ProductCategoryPOJO;
//import com.codecool.codecoolshopspring.service.ProductService;
//import com.fasterxml.jackson.databind.node.ObjectNode;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//
//public class ShopRestController {
//    private ProductService service;
//
//    @Autowired
//    public ShopRestController(ProductService service) {
//        this.service = service;
//    }
//
//    @PostMapping(value = "/", produces = "application/json")
//    public ProductCategoryPOJO createPerson(@RequestBody ObjectNode json) {
//        return new ProductCategoryPOJO(service.getProductCategory(1));
//    }
//}
