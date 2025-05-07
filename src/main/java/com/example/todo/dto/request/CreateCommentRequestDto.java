package com.example.todo.dto.request;

import lombok.Getter;

@Getter
public class CreateCommentRequestDto {

    private final String writerId;

    private final String content;

    public CreateCommentRequestDto(String writerId, String content) {
        this.writerId = writerId;
        this.content = content;
    }
}
