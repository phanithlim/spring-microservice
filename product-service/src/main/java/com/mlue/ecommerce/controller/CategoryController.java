package com.mlue.ecommerce.controller;

import com.mlue.ecommerce.core.ApiResponse;
import com.mlue.ecommerce.core.BaseController;
import com.mlue.ecommerce.dto.CategoryDto;
import com.mlue.ecommerce.dto.CategoryResponseDto;
import com.mlue.ecommerce.service.CategoryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@Tag(name = "Category", description = "Category management APIs")
@RequiredArgsConstructor
public class CategoryController extends BaseController {
    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<CategoryResponseDto>>> getAllCategories() {
        return getOkResponse(categoryService.getAllCategories());
    }

    @PostMapping
    public ResponseEntity<ApiResponse<CategoryResponseDto>> createCategory(@RequestBody CategoryDto categoryDto) {
        return getOkResponse(categoryService.createCategory(categoryDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<CategoryResponseDto>> getCategoryById(@PathVariable Long id) {
        return getOkResponse(categoryService.getCategoryById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<CategoryResponseDto>> updateCategory(@PathVariable Long id, @RequestBody CategoryDto categoryDto) {
        return getOkResponse(categoryService.updateCategory(id, categoryDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<CategoryResponseDto>> deleteCategory(@PathVariable Long id) {
        return getOkResponse(categoryService.deleteCategory(id));
    }


}
