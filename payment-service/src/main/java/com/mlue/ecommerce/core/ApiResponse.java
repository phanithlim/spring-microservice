package com.mlue.ecommerce.core;

import lombok.Data;

@Data
public class ApiResponse<T> {
    private Integer error;
    private String message;
    private T data;

    public ApiResponse() {
        this.error = 0;
        this.message = "S";
        this.data = null;
    }

    public ApiResponse(T data) {
        this.error = 0;
        this.message = "S";
        this.data = data;
    }

    public ApiResponse(Integer error, String message) {
        this.error = error;
        this.message = message;
        this.data = null;
    }

    public ApiResponse(Integer error, String message, T data) {
        this.error = error;
        this.message = message;
        this.data = data;
    }

    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(0, "S", data);
    }

    public static <T> ApiResponse<T> error(Integer error, String message) {
        return new ApiResponse<>(error, message, null);
    }
}
