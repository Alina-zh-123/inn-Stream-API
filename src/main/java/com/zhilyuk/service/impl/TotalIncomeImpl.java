package com.zhilyuk.service.impl;

import com.zhilyuk.entity.Order;
import com.zhilyuk.entity.OrderItem;
import com.zhilyuk.entity.OrderStatus;
import com.zhilyuk.service.TotalIncome;

import java.util.List;

public class TotalIncomeImpl implements TotalIncome {
    public double totalIncome(List<Order> orders) {
        return orders.stream()
                .filter(order -> order.getStatus() == OrderStatus.DELIVERED)
                .flatMap(order -> order.getItems().stream())
                .mapToDouble(OrderItem::getTotalPrice)
                .sum();
    }
}
