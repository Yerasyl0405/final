package com.softproject.SoftProject.controllers;

import com.softproject.SoftProject.OrderService;
import com.softproject.SoftProject.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/placeOrder")
    public String placeOrder(Model model) {
        User newOrder= new User();
        orderService.placeOrder(newOrder);
        model.addAttribute("order", newOrder);
        return "orderPlaced";
    }

    @GetMapping("/viewOrder/{orderId}")
    public String viewOrder(@PathVariable Long orderId, Model model) {
        User order = orderService.getOrderById(orderId);
        if (order != null) {
            model.addAttribute("order", order);
            return "viewOrder";
        } else {
            return "orderNotFound";
        }
    }
}
