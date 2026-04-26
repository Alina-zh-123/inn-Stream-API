package com.zhilyuk.service;

import com.zhilyuk.entity.Order;

import java.util.List;

public interface UniqueCities {
    List<String> uniqueCities(List<Order> orders);
}
