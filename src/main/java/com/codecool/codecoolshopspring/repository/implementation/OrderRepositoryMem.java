package com.codecool.codecoolshopspring.repository.implementation;

import com.codecool.codecoolshopspring.model.order.Order;
import com.codecool.codecoolshopspring.model.order.OrderStatus;
import com.codecool.codecoolshopspring.repository.OrderRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class OrderRepositoryMem implements OrderRepository {
    List<Order> orders = new ArrayList<>();

    @Override
    public void save(Order order) {
        orders.add(order);
    }

    @Override
    public Optional<Order> findByUserName(String userName) {
        for (Order order : orders){
            if (Objects.equals(order.getUserName(), userName) && order.getOrderStatus() == OrderStatus.PENDING){
                return Optional.of(order);
            }
        }
        return Optional.empty();
    }

    @Override
    public Integer findLastOrderId(){
        if (orders.size() != 0) {
            return orders.get(orders.size() - 1).getId();
        } else {
            return 0;
        }
    }
}
