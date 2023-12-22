package com.softproject.SoftProject;

import org.springframework.stereotype.Component;

@Component
class KaspiDelivery implements DeliveryStrategy {
    public double calculateCost(User order) {
        // Логика расчета стоимости для стандартной доставки
        return 5.0;
    }
}