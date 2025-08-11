package com.example.demo.utils.response;

import org.springframework.http.ResponseEntity;

public class ResponseHandler {

    public static <T> ResponseEntity<ApiResponse<T>> success(T data, String message, String code) {
        return ResponseEntity.ok(new ApiResponse<>(true, message, code, data));
    }

    public static <T> ResponseEntity<ApiResponse<T>> error(String message, String code) {
        return ResponseEntity.badRequest().body(new ApiResponse<>(false, message, code, null));
    }
}
