package com.mlue.ecommerce.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
@Data
public class Address {
    private String street;
    private String city;
    private String state;
    private String zip;
    private String country;
}
