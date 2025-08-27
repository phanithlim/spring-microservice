package com.mlue.ecommerce.client;

import com.mlue.ecommerce.core.ApiResponse;
import com.mlue.ecommerce.dto.CustomerResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "customer-service",
        url = "${application.config.customer-url}"
)
public interface CustomerClient {

    @GetMapping("/{customerId}")
    ApiResponse<CustomerResponseDto> getCustomer(@PathVariable String customerId);
}
