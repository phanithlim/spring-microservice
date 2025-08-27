package com.mlue.ecommerce.service;

import com.mlue.ecommerce.dto.ProductDto;
import com.mlue.ecommerce.dto.ProductPurchaseDto;
import com.mlue.ecommerce.dto.ProductPurchaseResponseDto;
import com.mlue.ecommerce.dto.ProductResponseDto;
import com.mlue.ecommerce.expection.NotFoundException;
import com.mlue.ecommerce.expection.PurchaseProductException;
import com.mlue.ecommerce.mapper.ProductMapper;
import com.mlue.ecommerce.model.Category;
import com.mlue.ecommerce.model.Product;
import com.mlue.ecommerce.repository.CategoryRepository;
import com.mlue.ecommerce.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

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
        return productRepository.findById(id)
                .map(ProductMapper.INSTANCE::toDto)
                .orElseThrow(() -> new NotFoundException("Product not found"));
    }

    @Override
    public ProductResponseDto updateProduct(Long id, ProductDto product) {
        return productRepository.findById(id).map(prod -> {
            Category category = categoryRepository.findById(product.categoryId()).orElseThrow(() -> new NotFoundException("Category not found"));
            prod.setCategory(category);
            return ProductMapper.INSTANCE.toDto(productRepository.save(prod));
        }).orElseThrow(() -> new NotFoundException("Product not found"));
    }

    @Override
    public ProductResponseDto deleteProduct(Long id) {
        return productRepository.findById(id).map(product -> {
            productRepository.deleteById(id);
            return ProductMapper.INSTANCE.toDto(product);
        }).orElseThrow(() -> new NotFoundException("Product not found"));
    }

    @Override
    public List<ProductResponseDto> getAllProducts() {
        return ProductMapper.INSTANCE.toDto(productRepository.findAll());
    }

    @Override
    public List<ProductPurchaseResponseDto> createProductPurchases(List<ProductPurchaseDto> productPurchases) {
        List<Long> ids = productPurchases.stream().map(ProductPurchaseDto::id).toList();
        List<Product> products = productRepository.findAllByIdInOrderById(ids);
        if (ids.isEmpty() && products.isEmpty()) {
            throw new EntityNotFoundException("Product not found");
        }
        List<ProductPurchaseDto> sortedDtos = productPurchases
                .stream()
                .sorted(Comparator.comparing(ProductPurchaseDto::id))
                .toList();
        List<ProductPurchaseResponseDto> purchases = new ArrayList<>();
        for (int i = 0; i < sortedDtos.size(); i++) {
            ProductPurchaseDto dto = sortedDtos.get(i);
            Product product = products.get(i);

            if (dto.quantity() > product.getAvailableQuantity()) {
                throw new PurchaseProductException("Quantity is greater than available quantity");
            }
            product.setAvailableQuantity(product.getAvailableQuantity() - dto.quantity());
            productRepository.save(product);
            purchases.add(ProductMapper.INSTANCE.toPurchaseDto(product, dto));
        }
        return purchases;
    }
}
