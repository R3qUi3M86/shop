package com.codecool.codecoolshopspring.service;

import com.codecool.codecoolshopspring.repository.OrderRepository;
import com.codecool.codecoolshopspring.repository.CategoryRepository;
import com.codecool.codecoolshopspring.repository.ProductRepository;
import com.codecool.codecoolshopspring.repository.SupplierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ShopService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final OrderRepository orderRepository;
    private final SupplierRepository supplierRepository;























}
