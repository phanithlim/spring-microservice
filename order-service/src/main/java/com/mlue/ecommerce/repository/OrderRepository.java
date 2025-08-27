package com.mlue.ecommerce.repository;

import com.mlue.ecommerce.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderRepository extends JpaRepository<Order, Long> {

}
