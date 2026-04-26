package com.zhilyuk.service.impl;

import com.zhilyuk.entity.Order;
import com.zhilyuk.entity.OrderItem;
import com.zhilyuk.entity.OrderStatus;
import com.zhilyuk.service.AverageCheck;

import java.util.List;

public class AverageCheckImpl implements AverageCheck {
    public double averageCheck(List<Order> orders) {
        return orders.stream()
                .filter(order -> order.getStatus() == OrderStatus.DELIVERED)
                .mapToDouble(order -> order.getItems().stream()
                        .mapToDouble(OrderItem::getTotalPrice)
                        .sum())
                .average()
                .orElse(0.0);
    }
}
