package com.example.todo.service;


import com.example.todo.dto.request.CreateCommentRequestDto;
import com.example.todo.dto.response.CommentWithRepliesDto;
import com.example.todo.dto.response.ReplyResponseDto;
import com.example.todo.entity.Comment;
import com.example.todo.entity.Reply;
import com.example.todo.repository.CommentRepository;
import com.example.todo.repository.ReplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReplyService {

    private final CommentRepository commentRepository;
    private final ReplyRepository replyRepository;


    public ReplyResponseDto createReply(Long commentId, CreateCommentRequestDto requestDto) {
        Comment comment = commentRepository.findByIdOrElseThrow(commentId);

        Reply reply = new Reply(comment,requestDto.getWriterId(),requestDto.getContent());

        Reply saved= replyRepository.save(reply);

        return new ReplyResponseDto(saved.getId(),saved.getWriterId(),saved.getContent());
    }

    public CommentWithRepliesDto findById(Long commentId) {

      Comment comment = commentRepository.findByIdOrElseThrow(commentId);

      List<Reply> replyList = replyRepository.findByCommentIdOrderByCreatedAtAsc(commentId);

      return CommentWithRepliesDto.toDto(comment,replyList);
    }
}
