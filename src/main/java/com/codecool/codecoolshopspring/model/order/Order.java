package com.codecool.codecoolshopspring.model.order;

import com.codecool.codecoolshopspring.model.product.Product;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class Order{

    private int id;
    private String name;
    private String description;
    private OrderStatus orderStatus = OrderStatus.PENDING;
    private Map<Product, Integer> orderedProducts = new HashMap<>();
    private BillingDetails billingDetails;

    public Order(int id, String name){
        this.id = id;
        this.name = name;
        this.description = ("order" + id);
    }

    public void addToOrder(Product product){
        if (orderedProducts.containsKey(product)){
            orderedProducts.put(product, orderedProducts.get(product) + 1);
        } else {
            orderedProducts.put(product, 1);
        }
    }

    public void removeFromOrder(Product product){
        if (orderedProducts.containsKey(product)){
            orderedProducts.put(product, orderedProducts.get(product) - 1);
            if (orderedProducts.get(product) == 0){
                orderedProducts.remove(product);
            }
        }
    }

    public Integer countProducts(){
        int count = 0;
        for (Product product : orderedProducts.keySet()){
            count += orderedProducts.get(product);
        }
        return count;
    }

    public Integer get(Product product) {
        return orderedProducts.get(product);
    }

}
