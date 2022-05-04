package com.codecool.codecoolshopspring.controller;

import com.codecool.codecoolshopspring.model.Order;
import com.codecool.codecoolshopspring.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

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

    @GetMapping("/checkout")
    public String checkout(Model model) {
//        String userName = "stiepan"; //TODO replace with cookie
//        Optional<Order> order = service.getUserOrder(userName);
//        if (order.isPresent()){
//            model.addAttribute("order", service.getUserOrder(userName).get());
//        } else {
//
//        }
//
        return "checkout/index";
    }
}
