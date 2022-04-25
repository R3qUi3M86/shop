package com.codecool.codecoolshopspring.controller;

import com.codecool.codecoolshopspring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {

    private ProductService service;

    @Autowired
    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("category", service.getProductCategory(1));
        model.addAttribute("products", service.getProductsForCategory(1));
        return "product/index";
    }
}
