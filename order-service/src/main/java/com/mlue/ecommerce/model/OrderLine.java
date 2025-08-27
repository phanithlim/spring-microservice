package com.mlue.ecommerce.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class OrderLine {
    @Id
    @GeneratedValue
    private Long id;

    private Long productId;
    private double quantity;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
}