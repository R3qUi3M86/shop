package com.codecool.codecoolshopspring.model.dto;

import com.codecool.codecoolshopspring.model.Order;
import com.codecool.codecoolshopspring.model.OrderStatus;

import java.util.HashMap;
import java.util.Map;

public class OrderDTO {
    OrderStatus orderStatus;
    Map<Integer, Integer> orderedProducts = new HashMap<>();

    public OrderDTO(Order order){
        this.orderStatus = order.getStatus();
        order.getProducts().forEach((key, quantity) -> orderedProducts.put(key.getId(), quantity));
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public Map<Integer, Integer> getOrderedProducts() {
        return orderedProducts;
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "orderStatus=" + orderStatus +
                ", orderedProducts=" + orderedProducts +
                '}';
    }
}
