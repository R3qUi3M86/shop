package com.codecool.codecoolshopspring.service;

import com.codecool.codecoolshopspring.model.Order;
import com.codecool.codecoolshopspring.model.dto.ProductCategoryDTO;
import com.codecool.codecoolshopspring.model.dto.ProductDTO;
import com.codecool.codecoolshopspring.repository.OrderRepository;
import com.codecool.codecoolshopspring.repository.ProductCategoryRepository;
import com.codecool.codecoolshopspring.repository.ProductRepository;
import com.codecool.codecoolshopspring.model.Product;
import com.codecool.codecoolshopspring.model.ProductCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ShopService {
    private ProductRepository productRepository;
    private ProductCategoryRepository productCategoryRepository;
    private OrderRepository orderRepository;

    @Autowired
    public ShopService(ProductRepository productRepository,
                       ProductCategoryRepository productCategoryRepository,
                       OrderRepository orderRepository) {
        this.productRepository = productRepository;
        this.productCategoryRepository = productCategoryRepository;
        this.orderRepository = orderRepository;
    }

    public ProductCategory getProductCategory(int categoryId){
        return productCategoryRepository.find(categoryId).orElseThrow();
    }

    public List<Product> getProductsForCategory(int categoryId){
        ProductCategory category = productCategoryRepository.find(categoryId).orElseThrow();
        return productRepository.findAllByProductCategory(category);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public List<ProductCategory> getAllProductCategories() {
        return productCategoryRepository.findAll();
    }

    public Optional<Order> getUserOrder(String userName) {
        return orderRepository.findByUserName(userName);
    }

    public Optional<Product> getProductById(int id){
        return productRepository.findById(id);
    }

    private void putNewOrder(Order order){
        orderRepository.save(order);
    }

    public Map<ProductDTO, Integer> addProductToOrder(String userName, Integer productId) {
        Optional<Product> optProduct = getProductById(productId);
        Map<ProductDTO, Integer> response = new HashMap<>();
        optProduct.ifPresent(product -> setOrder(product, userName, response));
        return response;
    }

    private void setOrder(Product product, String userName, Map<ProductDTO, Integer> response){
        Optional<Order> optOrder = getUserOrder(userName);
        Order order;
        if (optOrder.isEmpty()){
            order = new Order(orderRepository.findLastOrderId()+1, userName);
            putNewOrder(order);
        } else {
            order = optOrder.get();
        }
        order.addToOrder(product);
        response.put(new ProductDTO(product), order.getProducts().get(product));
    }
}
