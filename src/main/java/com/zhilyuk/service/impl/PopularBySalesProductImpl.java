package com.zhilyuk.service.impl;

import com.zhilyuk.entity.Order;
import com.zhilyuk.entity.OrderItem;
import com.zhilyuk.service.PopularBySalesProduct;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class PopularBySalesProductImpl implements PopularBySalesProduct {
    public String popularBySalesProduct(List<Order> orders) {
        return orders.stream()
                .flatMap(order -> order.getItems().stream())
                .max(Comparator.comparing(OrderItem::getQuantity))
                .map(OrderItem::getProductName)
                .orElse("");
    }
}
