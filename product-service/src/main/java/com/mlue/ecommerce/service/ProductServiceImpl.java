package com.mlue.ecommerce.service;

import com.mlue.ecommerce.dto.ProductDto;
import com.mlue.ecommerce.dto.ProductResponseDto;
import com.mlue.ecommerce.expection.NotFoundException;
import com.mlue.ecommerce.mapper.ProductMapper;
import com.mlue.ecommerce.model.Category;
import com.mlue.ecommerce.model.Product;
import com.mlue.ecommerce.repository.CategoryRepository;
import com.mlue.ecommerce.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;


    @Override
    public ProductResponseDto createProduct(ProductDto product) {
        Category category = categoryRepository.findById(product.categoryId()).orElseThrow(() -> new NotFoundException("Category not found"));
        Product prod = ProductMapper.INSTANCE.toEntity(product);
        prod.setCategory(category);
        return ProductMapper.INSTANCE.toDto(productRepository.save(prod));
    }

    @Override
    public ProductResponseDto getProductById(Long id) {
        return null;
    }

    @Override
    public ProductResponseDto updateProduct(Long id, ProductDto product) {
        return null;
    }

    @Override
    public ProductResponseDto deleteProduct(Long id) {
        return null;
    }
}
