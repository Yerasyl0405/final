package com.softproject.SoftProject.controllers;

import com.softproject.SoftProject.DeliveryService;
import com.softproject.SoftProject.EmailService;
import com.softproject.SoftProject.OrderService;
import com.softproject.SoftProject.User;
import com.softproject.SoftProject.repo.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegistrationController  {
    private final OrderService orderService;





    private final EmailService emailService;


    private UserRepository userRepository;
    private  DeliveryService deliveryService;


    public RegistrationController(OrderService orderService, EmailService emailService, UserRepository userRepository, DeliveryService deliveryService) {
        this.orderService = orderService;
        this.emailService = emailService;
        this.userRepository = userRepository;
        this.deliveryService = deliveryService;
    }


    @GetMapping("/registration")
        public String showRegistrationPage(@RequestParam(name = "productName", required = false) String productName, Model model) {
            model.addAttribute("productName", productName);
            // Other logic for the registration page
            return "registration";

        }


        // Other methods and logic



    @PostMapping("/registration")
    public String registerUser(@RequestParam String username,
                               @RequestParam String productname,
                               @RequestParam String password,
                               @RequestParam String gmail,
                               @RequestParam String deliveryOption,
                               User order, Model model) {
        User existingUser = userRepository.findByUsername(username);

        double deliveryCost = deliveryService.calculateDeliveryCost(deliveryOption, order);


        if (existingUser != null) {
            // Пользователь с таким именем уже существует, обработайте ситуацию по вашему усмотрению
            return "redirect:/registration?error";
        }

        User newUser = new User();
        String subject = "Подтверждение заказа";
        String text = "Ваш заказ успешно размещен. Спасибо за покупку!";
        emailService.sendEmail(gmail, subject, text);

        newUser.setUsername(username);
        newUser.setProductname(productname);
        newUser.setPassword(password);
        newUser.setGmail(gmail);
        newUser.setDeliverycost(deliveryCost);

        orderService.placeOrder(newUser);

        userRepository.save(newUser);

        // Уведомление наблюдателей о изменении статуса заказа


        return "redirect:/"; // или другая страница после успешной регистрации
    }




}