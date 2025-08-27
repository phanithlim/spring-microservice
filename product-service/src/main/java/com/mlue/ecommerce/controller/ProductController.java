package com.mlue.ecommerce.controller;

import com.mlue.ecommerce.core.ApiResponse;
import com.mlue.ecommerce.core.BaseController;
import com.mlue.ecommerce.dto.ProductDto;
import com.mlue.ecommerce.dto.ProductResponseDto;
import com.mlue.ecommerce.service.ProductService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@Tag(name = "Product", description = "Product management APIs")
@RequiredArgsConstructor
public class ProductController extends BaseController {
    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ApiResponse<ProductResponseDto>> createProduct(@RequestBody  ProductDto productDto) {
        return getOkResponse(productService.createProduct(productDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<ProductResponseDto>> readProduct(@RequestParam Long id) {
        return getOkResponse(productService.getProductById(id));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<ProductResponseDto>>> readAllProducts() {
        return getOkResponse(productService.getAllProducts());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<ProductResponseDto>> updateProduct(@RequestParam Long id, @RequestBody ProductDto productDto) {
        return getOkResponse(productService.updateProduct(id, productDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<ProductResponseDto>> deleteProduct(@RequestParam Long id) {
        return getOkResponse(productService.deleteProduct(id));
    }
}
