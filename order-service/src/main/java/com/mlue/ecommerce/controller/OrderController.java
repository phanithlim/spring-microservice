package com.mlue.ecommerce.controller;

import com.mlue.ecommerce.core.ApiResponse;
import com.mlue.ecommerce.core.BaseController;
import com.mlue.ecommerce.dto.OrderDto;
import com.mlue.ecommerce.dto.OrderResponseDto;
import com.mlue.ecommerce.service.OrderService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
@Tag(name = "Order")
@RequiredArgsConstructor
public class OrderController extends BaseController {
    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<ApiResponse<Long>> createOrder(@RequestBody OrderDto orderDto) {
        Long orderId = orderService.createOrder(orderDto);
        return getOkResponse(orderId);
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<OrderResponseDto>>> getAllOrders() {
        return getOkResponse(orderService.getAllOrders());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<OrderResponseDto>> getOrderById(@PathVariable Long id) {
        return getOkResponse(orderService.getOrderById(id));
    }
}
