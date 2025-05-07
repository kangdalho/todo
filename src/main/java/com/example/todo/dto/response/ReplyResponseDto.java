package com.example.todo.dto.response;



import lombok.Getter;




@Getter
public class ReplyResponseDto {

    private final Long replyId;

    private final String writerId;

    private final String content;



    public ReplyResponseDto(Long replyId, String writerId, String content) {
        this.replyId = replyId;
        this.writerId = writerId;
        this.content = content;
    }


}
