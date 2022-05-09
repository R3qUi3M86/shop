package com.codecool.codecoolshopspring.controller.rest;

import com.codecool.codecoolshopspring.model.order.Order;
import com.codecool.codecoolshopspring.model.order.OrderDTO;
import com.codecool.codecoolshopspring.service.order.OrderService;
import com.codecool.codecoolshopspring.service.product.ProductDTOService;
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
    private final OrderService orderService;
    private final ProductDTOService productDTOService;

    @PostMapping("/order/find")
    public Map<String, Object> getUserOrder(@RequestBody Map<String, Object> payload){
        Optional<Order> order =  orderService.getUserOrder((String) payload.get("userName"));
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
        return orderService.clearUserOrder((String) payload.get("userName"));
    }
}
