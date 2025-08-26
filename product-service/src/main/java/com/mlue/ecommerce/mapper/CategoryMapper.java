package com.mlue.ecommerce.mapper;

import com.mlue.ecommerce.dto.CategoryDto;
import com.mlue.ecommerce.dto.CategoryResponseDto;
import com.mlue.ecommerce.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CategoryMapper {
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    Category toEntity(CategoryDto categoryDto);
    CategoryResponseDto toDto(Category category);
    List<CategoryResponseDto> toDto(List<Category> categories);
    void updateCategory(@MappingTarget Category category, CategoryDto categoryDto);
}
