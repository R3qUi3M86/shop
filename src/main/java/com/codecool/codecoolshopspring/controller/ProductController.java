package com.codecool.codecoolshopspring.controller;

import com.codecool.codecoolshopspring.model.pojo.ProductCategoryPOJO;
import com.codecool.codecoolshopspring.service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class ProductController {

    private ProductService service;
    private ObjectMapper mapper;

    @Autowired
    public ProductController(ProductService service, ObjectMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("category", service.getProductCategory(1));
        model.addAttribute("products", service.getProductsForCategory(1));
        model.addAttribute("allCategories", service.getAllProductCategories());
        return "product/index";
    }

//    @PostMapping(value = "/", produces = "application/json")
//    public @ResponseBody ProductCategoryPOJO createPerson(@RequestBody ObjectNode json) {
//        return new ProductCategoryPOJO(service.getProductCategory(1));
//    }

    @GetMapping("/api/{categoryId}")
    public @ResponseBody ProductCategoryPOJO getProductsByCategory(@PathVariable String categoryId) {
        return new ProductCategoryPOJO(service.getProductCategory(Integer.parseInt(categoryId)));
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
