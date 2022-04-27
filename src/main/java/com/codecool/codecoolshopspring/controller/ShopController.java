package com.codecool.codecoolshopspring.controller;

import com.codecool.codecoolshopspring.service.ShopService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ShopController {

    private ShopService service;
    private ObjectMapper mapper;

    @Autowired
    public ShopController(ShopService service, ObjectMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("category", service.getProductCategory(1));
        model.addAttribute("products", service.getProductsForCategory(1));
        model.addAttribute("allCategories", service.getAllProductCategories());
        return "shop/index";
    }



//    @PostMapping("/")
//    public String filterByCategory(RedirectAttributes redirectAttributes, HttpServletRequest request) {
//        String categoryId = request.getParameter("category-select");
//        redirectAttributes.addAttribute("categoryId", Integer.valueOf(categoryId));
//        return "redirect:/{categoryId}";
//    }
//
//    @GetMapping("/{categoryId}")
//    public String displayProductsByCategory(Model model, @PathVariable int categoryId) {
//        model.addAttribute("category", service.getProductCategory(categoryId));
//        model.addAttribute("products", service.getProductsForCategory(categoryId));
//        model.addAttribute("allCategories", service.getAllProductCategories());
//        return "product/index";
//    }




//    @GetMapping("/display-by-category/{categoryId}")
//    public String displayProductsByCategory(Model model, @PathVariable int categoryId) {
//        model.addAttribute("category", service.getProductCategory(categoryId));
//        model.addAttribute("products", service.getProductsForCategory(categoryId));
//        model.addAttribute("allCategories", service.getAllProductCategories());
//        return "product/index";
//    }

}
