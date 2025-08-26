package com.mlue.ecommerce.mapper;

import com.mlue.ecommerce.dto.CustomerDto;
import com.mlue.ecommerce.dto.CustomerResponseDto;
import com.mlue.ecommerce.model.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);
    CustomerResponseDto toResponseDto(Customer customer);
    Customer toEntity(CustomerDto customerDto);
    List<CustomerResponseDto> toResponseDto(List<Customer> customers);
    void updateCustomerFromDto(@MappingTarget Customer customer, CustomerDto customerDto);
}
