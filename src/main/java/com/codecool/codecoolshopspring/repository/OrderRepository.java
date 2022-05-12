package com.codecool.codecoolshopspring.repository;

import com.codecool.codecoolshopspring.model.order.Order;
import com.codecool.codecoolshopspring.model.order.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderRepository  extends JpaRepository<Order, Integer> {
    Optional<Order> findOrderByOrderStatusAndUserName(OrderStatus orderStatus, String userName);
}
