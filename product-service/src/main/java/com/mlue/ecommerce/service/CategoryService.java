package com.mlue.ecommerce.service;

import com.mlue.ecommerce.dto.CategoryDto;
import com.mlue.ecommerce.dto.CategoryResponseDto;

import java.util.List;

public interface CategoryService {
    CategoryResponseDto createCategory(CategoryDto categoryDto);
    CategoryResponseDto getCategoryById(Long id);
    CategoryResponseDto updateCategory(Long id, CategoryDto categoryDto);
    CategoryResponseDto deleteCategory(Long id);
    List<CategoryResponseDto> getAllCategories();
}
