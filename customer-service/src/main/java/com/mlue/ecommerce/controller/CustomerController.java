package com.mlue.ecommerce.controller;

import com.mlue.ecommerce.core.ApiResponse;
import com.mlue.ecommerce.core.BaseController;
import com.mlue.ecommerce.dto.CustomerDto;
import com.mlue.ecommerce.dto.CustomerResponseDto;
import com.mlue.ecommerce.service.CustomerService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
@Slf4j
@Tag(name = "Customer", description = "Customer API")
@RequiredArgsConstructor
public class CustomerController extends BaseController {
    private final CustomerService customerService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<CustomerResponseDto>>> getCustomers() {
        return getOkResponse(customerService.getAllCustomers());
    }

    @PostMapping
    public ResponseEntity<ApiResponse<CustomerResponseDto>> createCustomer(@RequestBody CustomerDto customerDto) {
        return getOkResponse(customerService.createCustomer(customerDto));
    }

    @PutMapping("/{customerId}")
    public ResponseEntity<ApiResponse<CustomerResponseDto>> updateCustomer(@RequestBody CustomerDto customerDto, @PathVariable String customerId) {
        return getOkResponse(customerService.updateCustomer(customerDto, customerId));
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<ApiResponse<CustomerResponseDto>> getCustomer(@PathVariable String customerId) {
        return getOkResponse(customerService.getCustomer(customerId));
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity<ApiResponse<CustomerResponseDto>> deleteCustomer(@PathVariable String customerId) {
        return getOkResponse(customerService.deleteCustomer(customerId));
    }
}
