package com.zhilyuk.service;

import com.zhilyuk.entity.Order;

import java.util.List;

public interface PopularBySalesProduct {
    String popularBySalesProduct(List<Order> orders);
}
