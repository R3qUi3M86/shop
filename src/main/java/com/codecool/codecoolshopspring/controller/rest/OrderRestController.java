package com.codecool.codecoolshopspring.controller.rest;

import com.codecool.codecoolshopspring.model.Order;
import com.codecool.codecoolshopspring.model.dto.OrderDTO;
import com.codecool.codecoolshopspring.service.ProductDTOService;
import com.codecool.codecoolshopspring.service.ShopService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
@RequiredArgsConstructor
@RestController
public class OrderRestController {
    private final ShopService service;
    private final ProductDTOService productDTOService;

    @PostMapping("/order/find")
    public Map<String, Object> getUserOrder(@RequestBody Map<String, Object> payload){
        Optional<Order> order =  service.getUserOrder((String) payload.get("userName"));
        Map<String, Object> response = new HashMap<>();
        if (order.isPresent()) {
            OrderDTO orderDTO = new OrderDTO(order.get());
            response.put("order", orderDTO);
            response.put("products", productDTOService.getProductsDTOList(order.get().getOrderedProducts().keySet()));
        } else {
            response.put("order", "not found");
        }
        return response;
    }

    @PostMapping("/order/clear")
    public Map<String, String> emptyCurrentOrder(@RequestBody Map<String, Object> payload){
        return service.clearUserOrder((String) payload.get("userName"));
    }
}
