package com.codecool.codecoolshopspring.model.dto;

import com.codecool.codecoolshopspring.model.Order;
import com.codecool.codecoolshopspring.model.OrderStatus;

import java.util.HashMap;
import java.util.Map;

public class OrderDTO {
    OrderStatus orderStatus;
    Map<ProductDTO, Integer> orderedProducts = new HashMap<>();

    public OrderDTO(Order order){
        this.orderStatus = order.getStatus();
        order.getProducts().forEach((key, quantity) -> {
            ProductDTO productDTO = new ProductDTO(key);
            orderedProducts.put(productDTO, quantity);
        });
    }
}
