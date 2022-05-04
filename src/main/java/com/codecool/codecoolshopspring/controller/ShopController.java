package com.codecool.codecoolshopspring.controller;

import com.codecool.codecoolshopspring.model.Product;
import com.codecool.codecoolshopspring.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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
        return "shop/index";
    }

    @PostMapping("/checkout")
    public String checkout(@RequestBody Object order) {
        System.out.println(order);
        return "redirect:/checkout/index";
    }
}

