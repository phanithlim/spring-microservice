package com.mlue.ecommerce.service;

import com.mlue.ecommerce.dto.CustomerDto;
import com.mlue.ecommerce.dto.CustomerResponseDto;
import com.mlue.ecommerce.mapper.CustomerMapper;
import com.mlue.ecommerce.model.Customer;
import com.mlue.ecommerce.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    @Override
    public CustomerResponseDto createCustomer(CustomerDto customerDto) {
        Customer customer = CustomerMapper.INSTANCE.toEntity(customerDto);
        log.info("Customer : {}", customer);
        customerRepository.save(customer);
        CustomerResponseDto responseDto = CustomerMapper.INSTANCE.toResponseDto(customer);
        log.debug(responseDto.toString());
        return responseDto;
    }

    @Override
    public List<CustomerResponseDto> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        return  CustomerMapper.INSTANCE.toResponseDto(customers);
    }
}
