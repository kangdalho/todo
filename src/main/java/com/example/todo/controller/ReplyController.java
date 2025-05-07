package com.example.todo.controller;


import com.example.todo.dto.request.CreateCommentRequestDto;
import com.example.todo.dto.response.CommentWithRepliesDto;
import com.example.todo.dto.response.ReplyResponseDto;
import com.example.todo.service.ReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequiredArgsConstructor
public class ReplyController {

    private final ReplyService replyService;

    @PostMapping("/comments/{commentId}/replies")
    public ResponseEntity<ReplyResponseDto> createReply(
            @PathVariable Long commentId,
            @RequestBody CreateCommentRequestDto requestDto
            ) {
       ReplyResponseDto responseDto = replyService.createReply(commentId,requestDto);
       return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

    @GetMapping("/replies/{commentId}")
    public ResponseEntity<CommentWithRepliesDto> findReply(
            @PathVariable Long commentId
    ) {
      CommentWithRepliesDto findReply = replyService.findById(commentId);

      return new ResponseEntity<>(findReply,HttpStatus.OK);
    }
}
