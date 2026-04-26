package com.zhilyuk.service;

import com.zhilyuk.entity.Order;

import java.util.List;

public interface AverageCheck {
    double averageCheck(List<Order> orders);
}
