package com.codecool.codecoolshopspring.controller.rest;

import com.codecool.codecoolshopspring.service.ShopService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class CartRestController {

    private final ShopService service;

    @PostMapping("/cart/addProduct")
    public Map<String, Integer> addProductToCart(@RequestBody Map<String, Object> payload){
        String userName = (String) payload.get("userName");
        Integer prodId = Integer.parseInt((String) payload.get("productId"));
        return service.addProductToOrder(userName, prodId);
    }

    @PostMapping("/cart/removeProduct") // TODO change to DeleteMapping
    public Map<String, Integer> removeProductFromCart(@RequestBody Map<String, Object> payload){
        String userName = (String) payload.get("userName");
        Integer prodId = Integer.parseInt((String) payload.get("productId"));
        return service.removeProductFromOrder(userName, prodId);
    }
}
