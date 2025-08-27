package com.mlue.ecommerce.service;

import com.mlue.ecommerce.dto.ProductDto;
import com.mlue.ecommerce.dto.ProductResponseDto;

import java.util.List;

public interface ProductService {
    ProductResponseDto createProduct(ProductDto product);
    ProductResponseDto getProductById(Long id);
    ProductResponseDto updateProduct(Long id, ProductDto product);
    ProductResponseDto deleteProduct(Long id);
    List<ProductResponseDto> getAllProducts();
}
