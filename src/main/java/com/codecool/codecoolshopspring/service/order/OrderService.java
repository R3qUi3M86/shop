package com.codecool.codecoolshopspring.service.order;

import com.codecool.codecoolshopspring.model.order.Order;
import com.codecool.codecoolshopspring.model.order.OrderStatus;
import com.codecool.codecoolshopspring.model.product.Product;
import com.codecool.codecoolshopspring.repository.OrderRepository;
import com.codecool.codecoolshopspring.service.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final ProductService productService;
    private final OrderRepository orderRepository;

    public Optional<Order> getUserOrder(String userName) {
        return orderRepository.findOrderByOrderStatusAndUserName(OrderStatus.PENDING, userName);
    }

    public Map<String, String> clearUserOrder(String userName){
        Optional<Order> order = getUserOrder(userName);
        Map<String, String> response = new HashMap<>();
        if (order.isPresent()){
            order.get().setOrderedProducts(new HashMap<>());
            response.put("status", "order clear!");
        } else {
            response.put("status", "order not found!");
        }
        return response;
    }

    public Map<String, Integer> addProductToOrder(String userName, Integer productId) {
        Optional<Product> optProduct = productService.getProductById(productId);
        Map<String, Integer> response = new HashMap<>();
        optProduct.ifPresent(product -> setOrder(product, userName, response, true));
        return response;
    }

    public Map<String, Integer> removeProductFromOrder(String userName, Integer productId) {
        Optional<Product> optProduct = productService.getProductById(productId);
        Map<String, Integer> response = new HashMap<>();
        optProduct.ifPresent(product -> setOrder(product, userName, response, false));
        return response;
    }

    private void setOrder(Product product, String userName, Map<String, Integer> response, boolean add){
        Optional<Order> optOrder = getUserOrder(userName);
        Order order;
        if (optOrder.isEmpty()){
            order = new Order(userName);
            putOrder(order);
        } else {
            order = optOrder.get();
        }
        if (add) {
            order.addToOrder(product);
        } else {
            order.removeFromOrder(product);
        }
        orderRepository.save(order);
        response.put("productsCount", order.countProducts());
    }

    public BigDecimal getTotalOrderValue(Optional<Order> order) {
        BigDecimal result = new BigDecimal( 0);
        Order orderGet = order.get();
        for (Product product: orderGet.getOrderedProducts().keySet()) {
            result = result.add(product.getDefaultPrice().multiply(new BigDecimal(orderGet.get(product))));
        }
        return result;
    }

    public void putOrder(Order order){
        orderRepository.save(order);
    }
}
