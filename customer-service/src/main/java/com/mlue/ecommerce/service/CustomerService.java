package com.mlue.ecommerce.service;

import com.mlue.ecommerce.dto.CustomerDto;
import com.mlue.ecommerce.dto.CustomerResponseDto;

import java.util.List;

public interface CustomerService {
    CustomerResponseDto createCustomer(CustomerDto customerDto);
    List<CustomerResponseDto> getAllCustomers();
    CustomerResponseDto updateCustomer(CustomerDto customerDto, String id);
    CustomerResponseDto getCustomer(String id);
    CustomerResponseDto deleteCustomer(String id);
}
