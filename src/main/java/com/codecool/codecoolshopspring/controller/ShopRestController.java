package com.codecool.codecoolshopspring.controller;

import com.codecool.codecoolshopspring.model.dto.ProductCategoryDTO;
import com.codecool.codecoolshopspring.service.ShopService;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController // - using this makes controler not require @ResponseBody annotation in each function that returns JSON
public class ShopRestController {
    private ShopService service;

    @Autowired
    public ShopRestController(ShopService service) {
        this.service = service;
    }

    @PostMapping(value = "/", produces = "application/json")
    public @ResponseBody ProductCategoryDTO createPerson(@RequestBody ObjectNode json) {
        return new ProductCategoryDTO(service.getProductCategory(1));
    }
}
