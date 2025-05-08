package com.example.todo.dto.response;


import com.example.todo.entity.Comment;
import com.example.todo.entity.Schedule;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ScheduleResponseDto {

    private final Long id;

    private final String writerId;

    private final String title;

    private final String content;

    private final int commentCount;

    private final List<CommentResponseDto> comments;


    public ScheduleResponseDto(Long id, String writerId, String title, String content, int commentCount, List<CommentResponseDto> comments) {
        this.id = id;
        this.writerId = writerId;
        this.title = title;
        this.content = content;
        this.commentCount = commentCount;
        this.comments = comments;
    }

    public ScheduleResponseDto(Long id, String writerId, String title, String content, int commentCount) {
        this.id = id;
        this.writerId = writerId;
        this.title = title;
        this.content = content;
        this.commentCount = commentCount;
        this.comments = new ArrayList<>();
    }

    // Schedule 객체를 받아서 ScheduleResponseDto 객체로 변환하여 반환
    // 댓글 목록은 빈 리스트로 초기화되어 반환 (일정 목록 조회)
    public static ScheduleResponseDto toDto(Schedule schedule) {
        return new ScheduleResponseDto(
                schedule.getId(),
                schedule.getWriterId(),
                schedule.getTitle(),
                schedule.getContent(),
                schedule.getCommentCount(),
                new ArrayList<>() // 댓글 목록은 비워두고 반환
        );
    }

    // Schedule 객체와 댓글 목록을 받아서 ScheduleResponseDto 객체로 변환하여 반환
    // 댓글 목록은 실제 댓글을 포함하여 반환 (일정 상세 조회)
    public static ScheduleResponseDto toDto(Schedule schedule, List<Comment> commentList) {
       List<CommentResponseDto> commentListDto = commentList.stream()
                .map(comment -> new CommentResponseDto(
                        comment.getId(),
                        comment.getWriterId(),
                        comment.getContent()
                ))
                .toList();
        return new ScheduleResponseDto(
                schedule.getId(),
                schedule.getWriterId(),
                schedule.getTitle(),
                schedule.getContent(),
                schedule.getCommentCount(),
                commentListDto); // 댓글 목록 포함하여 반환
    }

}
