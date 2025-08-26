package com.mlue.ecommerce.service;

import com.mlue.ecommerce.dto.CustomerDto;
import com.mlue.ecommerce.dto.CustomerResponseDto;
import com.mlue.ecommerce.expection.NotFoundException;
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
        customerRepository.save(customer);
        return CustomerMapper.INSTANCE.toResponseDto(customer);
    }

    @Override
    public List<CustomerResponseDto> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        return  CustomerMapper.INSTANCE.toResponseDto(customers);
    }

    @Override
    public CustomerResponseDto updateCustomer(CustomerDto customerDto, String id) {
        return customerRepository.findById(id)
                .map(existingCustomer -> {
                    CustomerMapper.INSTANCE.updateCustomerFromDto(existingCustomer, customerDto);
                    customerRepository.save(existingCustomer);
                    return CustomerMapper.INSTANCE.toResponseDto(existingCustomer);
                })
                .orElseThrow(() -> new NotFoundException("Customer with id " + id + " not found"));
    }

    @Override
    public CustomerResponseDto getCustomer(String id) {
        return customerRepository.findById(id)
                .map(CustomerMapper.INSTANCE::toResponseDto)
                .orElseThrow(() -> new NotFoundException("Customer with id " + id + " not found"));
    }

    @Override
    public CustomerResponseDto deleteCustomer(String id) {
        return customerRepository.findById(id)
                .map(customer -> {
                    customerRepository.delete(customer);
                    return CustomerMapper.INSTANCE.toResponseDto(customer);
                })
                .orElseThrow(() -> new NotFoundException("Customer with id " + id + " not found"));
    }

}
