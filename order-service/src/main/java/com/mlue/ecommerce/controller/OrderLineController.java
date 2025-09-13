package com.mlue.ecommerce.controller;

import com.mlue.ecommerce.core.ApiResponse;
import com.mlue.ecommerce.core.BaseController;
import com.mlue.ecommerce.dto.OrderLineResponseDto;
import com.mlue.ecommerce.service.OrderLineService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/order-lines")
@RequiredArgsConstructor
@Tag(name = "Order Line")
public class OrderLineController extends BaseController {
    private final OrderLineService orderLineService;

    @GetMapping("/order/{id}")
    public ResponseEntity<ApiResponse<List<OrderLineResponseDto>>> getOrderLinesByOrderId(@PathVariable Long id) {
        return getOkResponse(orderLineService.getOrderLinesByOrderId(id));
    }
}
