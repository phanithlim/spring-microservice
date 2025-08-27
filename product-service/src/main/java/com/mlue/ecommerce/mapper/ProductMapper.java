package com.mlue.ecommerce.mapper;

import com.mlue.ecommerce.dto.ProductDto;
import com.mlue.ecommerce.dto.ProductPurchaseDto;
import com.mlue.ecommerce.dto.ProductPurchaseResponseDto;
import com.mlue.ecommerce.dto.ProductResponseDto;
import com.mlue.ecommerce.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    Product toEntity(ProductDto product);

    ProductResponseDto toDto(Product product);

    List<ProductResponseDto> toDto(List<Product> products);

    @Mapping(source = "product.id", target = "productId")
    @Mapping(source = "dto.quantity", target = "quantity")
    ProductPurchaseResponseDto toPurchaseDto(Product product, ProductPurchaseDto dto);
}
