package com.codecool.codecoolshopspring.model.order;

import lombok.Getter;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

@Getter
@ToString
public class OrderDTO {
    private final OrderStatus orderStatus;
    private final Map<Integer, Integer> orderedProducts = new HashMap<>();

    public OrderDTO(Order order){
        this.orderStatus = order.getOrderStatus();
        order.getOrderedProducts().forEach((key, quantity) -> orderedProducts.put(key.getId(), quantity));
    }
}
