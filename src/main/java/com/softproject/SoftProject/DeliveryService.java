package com.softproject.SoftProject;

import com.softproject.SoftProject.repo.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class DeliveryService {

    private final UserRepository orderRepository;

    public DeliveryService(UserRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public double calculateDeliveryCost(String deliveryOption, User order) {
        // Логика расчета стоимости доставки на сервере
        double orderTotal = 10;/* Логика получения общей суммы заказа */;
        double deliveryCost = 0.0;

        switch (deliveryOption) {
            case "option1":
                // Логика расчета стандартной доставки
                deliveryCost = 5.0;
                break;
            case "option2":
                // Логика расчета доставки Kaspi Pastomat
                deliveryCost = 7.0;
                break;
            case "option3":
                // Логика расчета экспресс-доставки
                deliveryCost = 10.0;
                break;
            default:
                // Действия по умолчанию
        }

        double totalCost = orderTotal + deliveryCost;

        // Сохранение стоимости доставки в базе данных
        order.setDeliverycost(deliveryCost);


        return totalCost;
    }
}
