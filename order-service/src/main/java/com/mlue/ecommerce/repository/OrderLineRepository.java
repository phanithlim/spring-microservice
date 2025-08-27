package com.mlue.ecommerce.repository;

import com.mlue.ecommerce.model.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderLineRepository extends JpaRepository<OrderLine, Long> {

}
