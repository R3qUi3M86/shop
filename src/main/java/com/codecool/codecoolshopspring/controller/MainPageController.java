package com.codecool.codecoolshopspring.controller;

import com.codecool.codecoolshopspring.service.ShopService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class MainPageController {

    private final ShopService service;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("products", service.getAllProducts());
        return "shop/index";
    }
}
