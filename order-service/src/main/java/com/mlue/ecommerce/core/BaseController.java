package com.mlue.ecommerce.core;

import org.springframework.http.ResponseEntity;

public class BaseController {
    protected <T> ResponseEntity<ApiResponse<T>> getOkResponse(T data) {
        return ResponseEntity.ok(new ApiResponse<T>(data));
    }
    protected <T> ResponseEntity<ApiResponse<T>> getOkResponse(ApiResponse<T> apiResponse) {
        return ResponseEntity.ok(apiResponse);
    }
}
