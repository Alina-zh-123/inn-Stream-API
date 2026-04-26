package com.zhilyuk.entity;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Order {
    private static long id = 0;

    private String orderId;
    private LocalDateTime orderDate;
    private Customer customer;
    private List<OrderItem> items;
    private OrderStatus status;

    public Order(LocalDateTime orderDate, Customer customer,  List<OrderItem> items, OrderStatus status) {
        this.orderId = String.valueOf(++id);
        this.orderDate = orderDate;
        this.customer = customer;
        this.items = items;
        this.status = status;
    }
}