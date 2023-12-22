package com.softproject.SoftProject;

import com.softproject.SoftProject.DeliveryService;
import com.softproject.SoftProject.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DeliveryController {

    private final DeliveryService deliveryService;

    public DeliveryController(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    @GetMapping("/deliveryCost")
    public String showDeliveryForm(Model model) {
        model.addAttribute("order", new User());
        return "deliveryCost";
    }

    @PostMapping("/calculateDeliveryCost")
    public String calculateDeliveryCost(@RequestParam String deliveryOption, User order, Model model) {
        double deliveryCost = deliveryService.calculateDeliveryCost(deliveryOption, order);

        model.addAttribute("order", order);
        model.addAttribute("deliveryCost", deliveryCost);

        return "deliveryCost";
    }
}
