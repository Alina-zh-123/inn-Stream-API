package com.zhilyuk.service.impl;

import com.zhilyuk.entity.Customer;
import com.zhilyuk.entity.Order;
import com.zhilyuk.service.UniqueCities;

import java.util.List;

public class UniqueCitiesImpl implements UniqueCities {
    @Override
    public List<String> uniqueCities(List<Order> orders) {
        return orders.stream()
                .map(Order::getCustomer)
                .map(Customer::getCity)
                .distinct()
                .toList();
    }
}
