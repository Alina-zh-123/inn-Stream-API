package com.zhilyuk.entity;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class OrderItem {
    private String productName;
    private int quantity;
    private double price;
    private Category category;

    public double getTotalPrice() {
        return quantity * price;
    }
}