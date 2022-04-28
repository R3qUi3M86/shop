package com.codecool.codecoolshopspring.repository.implementation;

import com.codecool.codecoolshopspring.model.Order;
import com.codecool.codecoolshopspring.model.OrderStatus;
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

    }

    @Override
    public Optional<Order> findByUserName(String userName) {
        for (Order order : orders){
            if (Objects.equals(order.getName(), userName) && order.getStatus() == OrderStatus.PENDING){
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
