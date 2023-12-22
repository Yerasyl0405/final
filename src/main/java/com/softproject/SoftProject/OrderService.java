package com.softproject.SoftProject;

import com.softproject.SoftProject.repo.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    private final EmailService emailService;



    private boolean ers;

    public boolean isErs() {
        return ers;
    }

    public void setErs(boolean ers) {
        this.ers = ers;
    }

    private List<OrderObserver> orderObservers = new ArrayList<>();
    private final UserRepository orderRepository;

    public OrderService(EmailService emailService, UserRepository orderRepository) {
        this.emailService = emailService;
        this.orderRepository = orderRepository;
    }

    public void addObserver(OrderObserver observer) {
        orderObservers.add(observer);
    }

    public void placeOrder(User order) {



        order.setStatus("В обработке");
        orderRepository.save(order);

        notifyObservers(order);
    }

    public User getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    private void notifyObservers(User order) {
        for (OrderObserver observer : orderObservers) {
            observer.update(order);
        }
    }

}

