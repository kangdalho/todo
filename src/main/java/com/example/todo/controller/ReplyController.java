package com.example.todo.controller;


import com.example.todo.common.ApiResponseDto;
import com.example.todo.common.SuccessCode;
import com.example.todo.dto.request.CreateCommentRequestDto;
import com.example.todo.dto.request.UpdateReplyRequestDto;
import com.example.todo.dto.response.CommentWithRepliesDto;
import com.example.todo.dto.response.ReplyResponseDto;
import com.example.todo.service.ReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
public class ReplyController {

    private final ReplyService replyService;

    @PostMapping("/comments/{commentId}/replies")
    public ResponseEntity<ApiResponseDto<ReplyResponseDto>> createReply(
            @PathVariable Long commentId,
            @RequestBody CreateCommentRequestDto requestDto
    ) {
        ReplyResponseDto responseDto = replyService.createReply(commentId, requestDto);
        return ResponseEntity.ok(ApiResponseDto.success(SuccessCode.REPLY_CREATE_SUCCESS, responseDto));
    }

    @GetMapping("/replies/{commentId}")
    public ResponseEntity<ApiResponseDto<CommentWithRepliesDto>> findReply(
            @PathVariable Long commentId
    ) {
        CommentWithRepliesDto findReply = replyService.findById(commentId);

        return ResponseEntity.ok(ApiResponseDto.success(SuccessCode.REPLY_FIND_SUCCESS, findReply));
    }

    @PatchMapping("/replies/{replyId}")
    public ResponseEntity<ApiResponseDto<ReplyResponseDto>> updateReply(
            @PathVariable Long replyId,
            @RequestBody UpdateReplyRequestDto requestDto
    ) {
        ReplyResponseDto updatedReply = replyService.updateReply(replyId, requestDto.getContent());
        return ResponseEntity.ok(ApiResponseDto.success(SuccessCode.REPLY_UPDATE_SUCCESS,updatedReply));
    }

    @DeleteMapping("/replies/{replyId}")
    public ResponseEntity<ApiResponseDto<Void>> deleteReply(
            @PathVariable Long replyId
    ) {
        replyService.deleteReply(replyId);
        return ResponseEntity.ok(ApiResponseDto.success(SuccessCode.REPLY_DELETE_SUCCESS,null));
    }


}
