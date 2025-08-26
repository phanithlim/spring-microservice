package com.mlue.ecommerce.service;

import com.mlue.ecommerce.dto.ProductDto;
import com.mlue.ecommerce.dto.ProductResponseDto;

public interface ProductService {
    ProductResponseDto createProduct(ProductDto product);
    ProductResponseDto getProductById(Long id);
    ProductResponseDto updateProduct(Long id, ProductDto product);
    ProductResponseDto deleteProduct(Long id);
}
