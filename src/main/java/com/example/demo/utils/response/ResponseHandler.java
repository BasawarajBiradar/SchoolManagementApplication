package com.example.demo.utils.response;

import org.springframework.http.ResponseEntity;

public class ResponseHandler {

    public static <T> ResponseEntity<ApiResponse<T>> success(T data, String message, String code) {
        return ResponseEntity
                .status(Integer.parseInt(code))
                .body(new ApiResponse<>(true, message, code, data));
    }

    public static <T> ResponseEntity<ApiResponse<T>> error(String message, String code) {
        return ResponseEntity
                .status(Integer.parseInt(code))
                .body(new ApiResponse<>(false, message, code, null));
    }

    public static <T> ResponseEntity<ApiResponse<T>> error(T data, String message, String code) {
        return ResponseEntity
                .status(Integer.parseInt(code))
                .body(new ApiResponse<>(false, message, code, data));
    }
}
