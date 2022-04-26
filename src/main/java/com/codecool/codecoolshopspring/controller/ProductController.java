package com.codecool.codecoolshopspring.controller;

import com.codecool.codecoolshopspring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
        model.addAttribute("allCategories", service.getAllProductCategories());
        return "product/index";
    }

    @PostMapping("/")
    public String filterByCategory(RedirectAttributes redirectAttributes, HttpServletRequest request) {
        String categoryId = request.getParameter("category-select");
        redirectAttributes.addAttribute("categoryId", Integer.valueOf(categoryId));
        return "redirect:/{categoryId}";
    }

    @GetMapping("/{categoryId}")
    public String displayProductsByCategory(Model model, @PathVariable int categoryId) {
        model.addAttribute("category", service.getProductCategory(categoryId));
        model.addAttribute("products", service.getProductsForCategory(categoryId));
        model.addAttribute("allCategories", service.getAllProductCategories());
        return "product/index";
    }


//    @GetMapping("/display-by-category/{categoryId}")
//    public String displayProductsByCategory(Model model, @PathVariable int categoryId) {
//        model.addAttribute("category", service.getProductCategory(categoryId));
//        model.addAttribute("products", service.getProductsForCategory(categoryId));
//        model.addAttribute("allCategories", service.getAllProductCategories());
//        return "product/index";
//    }

}
