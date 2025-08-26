package com.mlue.ecommerce.service;

import com.mlue.ecommerce.dto.CategoryDto;
import com.mlue.ecommerce.dto.CategoryResponseDto;
import com.mlue.ecommerce.expection.NotFoundException;
import com.mlue.ecommerce.mapper.CategoryMapper;
import com.mlue.ecommerce.model.Category;
import com.mlue.ecommerce.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public CategoryResponseDto createCategory(CategoryDto categoryDto) {
        Category category = CategoryMapper.INSTANCE.toEntity(categoryDto);
        categoryRepository.save(category);
        return CategoryMapper.INSTANCE.toDto(category);
    }

    @Override
    public CategoryResponseDto getCategoryById(Long id) {
        return categoryRepository.findById(id)
                .map(CategoryMapper.INSTANCE::toDto)
                .orElseThrow(() -> new NotFoundException("Category not found"));
    }

    @Override
    public CategoryResponseDto updateCategory(Long id, CategoryDto categoryDto) {
        return categoryRepository.findById(id)
                .map(existingCategory -> {
                    CategoryMapper.INSTANCE.updateCategory(existingCategory, categoryDto);
                    categoryRepository.save(existingCategory);
                    return CategoryMapper.INSTANCE.toDto(existingCategory);
                })
                .orElseThrow(() -> new NotFoundException("Category not found"));
    }

    @Override
    public CategoryResponseDto deleteCategory(Long id) {
        return categoryRepository.findById(id)
                .map(category -> {
                    categoryRepository.delete(category);
                    return CategoryMapper.INSTANCE.toDto(category);
                })
                .orElseThrow(() -> new NotFoundException("Category not found"));
    }

    @Override
    public List<CategoryResponseDto> getAllCategories() {
        return CategoryMapper.INSTANCE.toDto(categoryRepository.findAll());
    }
}
