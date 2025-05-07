package com.example.todo.dto.request;


import lombok.Getter;

@Getter
public class CreateReplyRequestDto {

    private final String writerId;

    private final String content;

    public CreateReplyRequestDto(String writerId, String content) {
        this.writerId = writerId;
        this.content = content;
    }
}
