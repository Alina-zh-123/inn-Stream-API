package com.zhilyuk.service;

import com.zhilyuk.entity.Customer;
import com.zhilyuk.entity.Order;

import java.util.List;

public interface CustomersMoreFiveOrders {
    List<Customer> customersMoreFiveOrders(List<Order> orders);
}
