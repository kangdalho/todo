package com.example.todo.dto.response;


import lombok.Getter;

@Getter
public class CommentResponseDto {

    private final Long commentId;

    private final String writerId;

    private final String content;

    public CommentResponseDto(Long commentId, String writerId, String content) {
        this.commentId = commentId;
        this.writerId = writerId;
        this.content = content;
    }
}
