package com.codecool.codecoolshopspring.controller.rest;

import com.codecool.codecoolshopspring.service.order.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class CartRestController {

    private final OrderService orderService;

    @PostMapping("/cart/addProduct")
    public Map<String, Integer> addProductToCart(@RequestBody Map<String, Object> payload){
        String userName = (String) payload.get("userName");
        Integer prodId = Integer.parseInt((String) payload.get("productId"));
        return orderService.addProductToOrder(userName, prodId);
    }

    @DeleteMapping("/cart/removeProduct")
    public Map<String, Integer> removeProductFromCart(@RequestBody Map<String, Object> payload){
        String userName = (String) payload.get("userName");
        Integer prodId = Integer.parseInt((String) payload.get("productId"));
        return orderService.removeProductFromOrder(userName, prodId);
    }
}
