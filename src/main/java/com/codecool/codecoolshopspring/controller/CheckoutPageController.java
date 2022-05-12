package com.codecool.codecoolshopspring.controller;

import com.codecool.codecoolshopspring.model.billingDetails.BillingDetails;
import com.codecool.codecoolshopspring.model.order.Order;
import com.codecool.codecoolshopspring.model.order.OrderStatus;
import com.codecool.codecoolshopspring.service.billingDetails.BillingDetailsService;
import com.codecool.codecoolshopspring.service.order.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Optional;

@RequiredArgsConstructor
@Controller
public class CheckoutPageController {

    private final OrderService orderService;
    private final BillingDetailsService billingDetailsService;

    @GetMapping("/checkout")
    public String checkout(Model model, BillingDetails billingDetails) {
        String userName = "stiepan"; //TODO replace with cookie
        Optional<Order> order = orderService.getUserOrder(userName);
        if (order.isPresent()) {
            model.addAttribute("order", order.get());
            model.addAttribute("products", order.get().getOrderedProducts().keySet().toArray());
            model.addAttribute("totalPrice", orderService.getTotalOrderValue(order));
            model.addAttribute("billingDetails", billingDetails);
            return "checkout/index";
        } else {
            return "checkout/orderNotFound";
        }
    }

    @PostMapping("/finalizeOrder")
    public String finalizeOrder(Model model, @Valid BillingDetails billingDetails, BindingResult bindingResult){
        String userName = "stiepan"; //TODO replace with cookie
        Optional<Order> order = orderService.getUserOrder(userName);
        if (bindingResult.hasErrors()) {
//            bindingResult.getFieldErrors().forEach(e -> billingDetails.removeRejectedValue(e.getRejectedValue()));
            return checkout(model, billingDetails);
        } else {
            if (order.isPresent()) {
                order.get().setOrderStatus(OrderStatus.PROCESSING);
                order.get().setBillingDetails(billingDetails);
                billingDetailsService.putBillingDetails(billingDetails);
                orderService.putOrder(order.get());
//            BufferedWriter writer = new BufferedWriter(new FileWriter(order.get().getId() + ".log"));
//            writer.write(order.get().toString());
//            writer.close();
                return "checkout/finalize";
            } else {
                return "checkout/orderNotFound";
            }
        }
    }
}
