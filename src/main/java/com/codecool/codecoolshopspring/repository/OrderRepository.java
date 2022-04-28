package com.codecool.codecoolshopspring.repository;

import com.codecool.codecoolshopspring.model.Order;

import java.util.List;
import java.util.Optional;

public interface OrderRepository {
    void save(Order order);
    Optional<Order> findByUserName(String userName);
    Integer findLastOrderId();
}
