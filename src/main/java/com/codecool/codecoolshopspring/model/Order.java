package com.codecool.codecoolshopspring.model;

import java.util.HashMap;
import java.util.Map;

public class Order extends BaseModel{
    OrderStatus orderStatus = OrderStatus.PENDING;
    Map<Product, Integer> orderedProducts = new HashMap<>();

    public Order(int id, String userName){
        super(userName, ("order" + id));
        this.id = id;
    }

    public void addToOrder(Product product){
        if (orderedProducts.containsKey(product)){
            orderedProducts.put(product, orderedProducts.get(product) + 1);
        } else {
            orderedProducts.put(product, 1);
        }
    }

    public OrderStatus getStatus() {
        return orderStatus;
    }

    public Map<Product, Integer> getProducts() {
        return orderedProducts;
    }

    public Integer countProducts(){
        int count = 0;
        for (Product product : orderedProducts.keySet()){
            count += orderedProducts.get(product);
        }
        return count;
    }
}
