package com.trexgames.server.exception;

import lombok.Getter;
import org.springframework.http.ResponseEntity;

@Getter
public class ApiResponse<T> {
    private String code;
    private String message;
    private T data;

    ApiResponse(ResponseCode responseCode, T data) {
        this.code = responseCode.getCode();
        this.message = responseCode.getMessage();
        this.data = data;
    }

    public static <T> ResponseEntity<ApiResponse<T>> create(ResponseCode responseCode, T data) {
        return new ResponseEntity<>(new ApiResponse<>(responseCode, data), responseCode.getHttpStatus());
    }

    public static ResponseEntity<ApiResponse<Void>> create(ResponseCode responseCode) {
        return new ResponseEntity<>(new ApiResponse<>(responseCode, null), responseCode.getHttpStatus());
    }

}
