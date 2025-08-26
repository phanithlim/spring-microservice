package com.mlue.ecommerce.controller;

import com.mlue.ecommerce.dto.CustomerDto;
import com.mlue.ecommerce.dto.CustomerResponseDto;
import com.mlue.ecommerce.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
@Slf4j
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;


    @GetMapping
    public ResponseEntity<List<CustomerResponseDto>> getCustomers() {
        return ResponseEntity.ok(customerService.getAllCustomers());
    }

    @PostMapping
    public ResponseEntity<CustomerResponseDto> createCustomer(@RequestBody CustomerDto customerDto) {
        return ResponseEntity.ok(customerService.createCustomer(customerDto));
    }


}
