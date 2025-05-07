package com.example.todo.dto.response;


import com.example.todo.entity.Comment;
import com.example.todo.entity.Reply;
import lombok.Getter;

import java.util.List;

@Getter
public class CommentWithRepliesDto {
    private final Long commentId;
    private final String writerId;
    private final String content;
    private final List<ReplyResponseDto> replies;

    public CommentWithRepliesDto(Long commentId, String writerId, String content, List<ReplyResponseDto> replies) {
        this.commentId = commentId;
        this.writerId = writerId;
        this.content = content;
        this.replies = replies;
    }

    public static CommentWithRepliesDto toDto(Comment comment, List<Reply> replyList) {
        List<ReplyResponseDto> replyDtos = replyList.stream()
                .map(reply -> new ReplyResponseDto (
                        reply.getId(),
                        reply.getWriterId(),
                        reply.getContent()
                ))
                .toList();
        return new CommentWithRepliesDto (
                comment.getId(),
                comment.getWriterId(),
                comment.getContent(),
                replyDtos);

    }

}
