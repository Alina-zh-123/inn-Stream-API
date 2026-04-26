package com.zhilyuk.service;

import com.zhilyuk.entity.Order;

import java.util.List;

public interface TotalIncome {
    double totalIncome(List<Order> orders);
}
