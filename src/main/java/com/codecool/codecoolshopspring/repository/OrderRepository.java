package com.codecool.codecoolshopspring.repository;

import com.codecool.codecoolshopspring.model.order.Order;

import java.util.Optional;

public interface OrderRepository {
    void save(Order order);
    Optional<Order> findByUserName(String userName);
    Integer findLastOrderId();
}
