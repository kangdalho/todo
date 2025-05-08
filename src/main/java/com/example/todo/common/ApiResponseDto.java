package com.example.todo.common;


import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;

import java.time.LocalDateTime;

@JsonPropertyOrder({"timestamp", "data", "message"})
@Getter
public class ApiResponseDto<T> {

    private final LocalDateTime timeStamp;

    private final T data;

    private final String message;

    public ApiResponseDto(SuccessCode successCode, T data) {
        this.timeStamp = LocalDateTime.now();
        this.data = data;
        this.message = successCode.getMessage();
    }

    public static <T> ApiResponseDto<T> success(SuccessCode successCode, T data) {

        return new ApiResponseDto<>(successCode, data);
    }

}
