package com.zhilyuk.service.impl;

import com.zhilyuk.entity.Customer;
import com.zhilyuk.entity.Order;
import com.zhilyuk.service.CustomersMoreFiveOrders;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CustomersMoreFiveOrdersImpl implements CustomersMoreFiveOrders {
    public List<Customer> customersMoreFiveOrders(List<Order> orders) {
        return orders.stream()
                .collect(Collectors.groupingBy(Order::getCustomer, Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() > 5)
                .map(Map.Entry::getKey)
                .toList();
    }
}
