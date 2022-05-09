package com.codecool.codecoolshopspring.controller;

import com.codecool.codecoolshopspring.model.order.BillingDetails;
import com.codecool.codecoolshopspring.model.order.Order;
import com.codecool.codecoolshopspring.model.order.OrderStatus;
import com.codecool.codecoolshopspring.service.order.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Optional;

@RequiredArgsConstructor
@Controller
public class CheckoutPageController {

    private final OrderService orderService;

    @GetMapping("/checkout")
    public String checkout(Model model) {
        String userName = "stiepan"; //TODO replace with cookie
        Optional<Order> order = orderService.getUserOrder(userName);
        if (order.isPresent()) {
            model.addAttribute("order", order.get());
            model.addAttribute("products", order.get().getOrderedProducts().keySet().toArray());
            model.addAttribute("totalPrice", orderService.getTotalOrderValue(order));
            model.addAttribute("billingDetails", new BillingDetails());
            return "checkout/index";
        } else {
            return "checkout/orderNotFound";
        }
    }

    @PostMapping("/finalizeOrder")
    public String finalizeOrder(@ModelAttribute BillingDetails billingDetails) throws IOException {
        String userName = "stiepan"; //TODO replace with cookie
        Optional<Order> order = orderService.getUserOrder(userName);
        if (order.isPresent()) {
            order.get().setOrderStatus(OrderStatus.PROCESSING);
            order.get().setBillingDetails(billingDetails);
            BufferedWriter writer = new BufferedWriter(new FileWriter(order.get().getId() + ".log"));
            writer.write(order.get().toString());
            writer.close();
            return "checkout/finalize";
        } else {
            return "checkout/orderNotFound";
        }
    }
}
