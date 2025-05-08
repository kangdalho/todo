package com.example.todo.controller;


import com.example.todo.common.ApiResponseDto;
import com.example.todo.common.SuccessCode;
import com.example.todo.dto.request.CreateCommentRequestDto;
import com.example.todo.dto.request.UpdateCommentRequestDto;
import com.example.todo.dto.response.CommentResponseDto;
import com.example.todo.service.CommentService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/schedules/{scheduleId}/comments")
    public ResponseEntity<ApiResponseDto<CommentResponseDto>> createComment(
            @PathVariable Long scheduleId,
            @RequestBody CreateCommentRequestDto requestDto
    ) {
        CommentResponseDto responseDto = commentService.createComment(scheduleId, requestDto);
        return ResponseEntity.ok(ApiResponseDto.success(SuccessCode.COMMENT_CREATE_SUCCESS,responseDto));
    }

    @GetMapping("/comments/{commentId}")
    public ResponseEntity<ApiResponseDto<CommentResponseDto>> findById(
            @PathVariable Long commentId
    ) {
        CommentResponseDto findComment = commentService.findById(commentId);
        return ResponseEntity.ok(ApiResponseDto.success(SuccessCode.COMMENT_FIND_SUCCESS,findComment));
    }

    @PatchMapping("/comments/{commentId}")
    public ResponseEntity<ApiResponseDto<CommentResponseDto>> updateComment(
            @PathVariable Long commentId,
            @RequestBody UpdateCommentRequestDto requestDto
    ) {
       CommentResponseDto responseDto = commentService.updateComment(commentId,requestDto.getContent());
       return ResponseEntity.ok(ApiResponseDto.success(SuccessCode.COMMENT_UPDATE_SUCCESS,responseDto));
    }

    @DeleteMapping("/comments/{commentId}")
    public ResponseEntity<ApiResponseDto<Void>> delete(
            @PathVariable Long commentId
    ) {
        commentService.delete(commentId);
        return ResponseEntity.ok(ApiResponseDto.success(SuccessCode.COMMENT_DELETE_SUCCESS,null));
    }
}
