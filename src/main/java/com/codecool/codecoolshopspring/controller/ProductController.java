package com.codecool.codecoolshopspring.controller;

import com.codecool.codecoolshopspring.model.Product;
import com.codecool.codecoolshopspring.model.ProductCategory;
import com.codecool.codecoolshopspring.model.pojo.ProductCategoryPOJO;
import com.codecool.codecoolshopspring.model.pojo.ProductPOJO;
import com.codecool.codecoolshopspring.service.ProductService;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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
    @JsonProperty("")
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

    @GetMapping("/display-products/{categoryId}")
    public @ResponseBody List<ProductPOJO> getProductsByCategory(@PathVariable String categoryId) {
        ProductCategory productCategory = service.getProductCategory(Integer.parseInt(categoryId));
        return new ProductCategoryPOJO(productCategory).getProducts();
    }

//



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
