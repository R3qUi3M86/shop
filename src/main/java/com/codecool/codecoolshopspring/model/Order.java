package com.codecool.codecoolshopspring.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

@Data
public class Order extends BaseModel{

    private OrderStatus orderStatus = OrderStatus.PENDING;
    private Map<Product, Integer> orderedProducts = new HashMap<>();
    private BillingDetails billingDetails;

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
