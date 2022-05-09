package com.codecool.codecoolshopspring.repository;

import com.codecool.codecoolshopspring.model.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface OrderRepository  extends JpaRepository<Order, Integer> {
    @Query("select o from Order o where o.orderStatus = 0")
    Optional<Order> findPendingByUserName(String userName);
}
