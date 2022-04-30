package com.codecool.codecoolshopspring.controller;

import com.codecool.codecoolshopspring.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShopController {
    private final ShopService service;

    @Autowired
    public ShopController(ShopService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("products", service.getAllProducts());
        return "Shop/index";
    }

    @GetMapping("/checkout")
    public String checkout() {
        return "Checkout/index";
    }
}
