package com.example.todo.controller;


import com.example.todo.dto.request.CreateCommentRequestDto;
import com.example.todo.dto.request.UpdateCommentRequestDto;
import com.example.todo.dto.response.CommentResponseDto;
import com.example.todo.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/schedules/{scheduleId}/comments")
    public ResponseEntity<CommentResponseDto> createComment(
            @PathVariable Long scheduleId,
            @RequestBody CreateCommentRequestDto requestDto
    ) {
        CommentResponseDto responseDto = commentService.createComment(scheduleId, requestDto);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

    @GetMapping("/comments/{commentId}")
    public ResponseEntity<CommentResponseDto> findById(
            @PathVariable Long commentId
    ) {
        CommentResponseDto findComment = commentService.findById(commentId);
        return new ResponseEntity<>(findComment, HttpStatus.OK);
    }

    @PatchMapping("/comments/{commentId}")
    public ResponseEntity<CommentResponseDto> updateComment(
            @PathVariable Long commentId,
            @RequestBody UpdateCommentRequestDto requestDto
    ) {
       CommentResponseDto responseDto = commentService.updateComment(commentId,requestDto.getContent());
       return new ResponseEntity<>(responseDto,HttpStatus.OK);
    }

    @DeleteMapping("/comments/{commentId}")
    public ResponseEntity<Void> delete(
            @PathVariable Long commentId
    ) {
        commentService.delete(commentId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
