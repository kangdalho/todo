package com.example.todo.dto.request;


import lombok.Getter;

@Getter
public class UpdateReplyRequestDto {

    private final String content;

    public UpdateReplyRequestDto(String content) {
        this.content = content;
    }
}
