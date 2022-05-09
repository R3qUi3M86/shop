package com.codecool.codecoolshopspring.model.order;

import com.codecool.codecoolshopspring.model.billingDetails.BillingDetails;
import com.codecool.codecoolshopspring.model.product.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Order{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    private String userName;
    private OrderStatus orderStatus = OrderStatus.PENDING;
    @ElementCollection
    @CollectionTable(name = "order_item_mapping",
            joinColumns = {@JoinColumn(name = "order_id", referencedColumnName = "id")})
    @MapKeyColumn(name = "product")
    @Column(name = "quantity")
    private Map<Product, Integer> orderedProducts = new HashMap<>();
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "billing_details_id")
    private BillingDetails billingDetails;

    public Order(String userName){
        this.userName = userName;
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
