package com.codecool.codecoolshopspring.model;

import java.util.HashMap;
import java.util.Map;

public class Order extends BaseModel{
    OrderStatus orderStatus = OrderStatus.PENDING;
    Map<Product, Integer> orderedProducts = new HashMap<>();

    BillingDetails billingDetails;

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

    public void setOrderedProducts(Map<Product, Integer> orderedProducts) {
        this.orderedProducts = orderedProducts;
    }

    public Integer get(Product product) {
        return orderedProducts.get(product);
    }

    public void setBillingDetails(BillingDetails billingDetails) {
        this.billingDetails = billingDetails;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderStatus=" + orderStatus +
                ", orderedProducts=" + orderedProducts +
                ", billingDetails=" + billingDetails +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
