package com.example.todo.service;

import com.example.todo.dto.request.CreateCommentRequestDto;
import com.example.todo.dto.response.CommentResponseDto;
import com.example.todo.entity.Comment;
import com.example.todo.entity.Schedule;
import com.example.todo.repository.CommentRepository;
import com.example.todo.repository.ScheduleRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CommentService {

    private final ScheduleRepository scheduleRepository;
    private final CommentRepository commentRepository;

    //댓글 생성
    public CommentResponseDto createComment(Long scheduleId, CreateCommentRequestDto requestDto) {

        Schedule schedule = scheduleRepository.findByIdOrElseThrow(scheduleId);

        Comment comment = new Comment(schedule, requestDto.getWriterId(), requestDto.getContent());

        Comment saved = commentRepository.save(comment);

        schedule.increaseCommentCount();

        scheduleRepository.save(schedule);

        return new CommentResponseDto(saved.getId(), saved.getWriterId(), saved.getContent());

    }

    //댓글 단건 조회
    public CommentResponseDto findById(Long commentId) {

        Comment comment = commentRepository.findByIdOrElseThrow(commentId);

        return new CommentResponseDto(comment.getId(), comment.getWriterId(), comment.getContent());
    }

    //댓글 수정
    @Transactional
    public CommentResponseDto updateComment(Long commentId, String content) {

        Comment comment = commentRepository.findByIdOrElseThrow(commentId);

        comment.update(content);

        return new CommentResponseDto(comment.getId(), comment.getWriterId(), comment.getContent());
    }

    //댓글 삭제
    public void delete(Long commentId) {
        Comment comment = commentRepository.findByIdOrElseThrow(commentId);

        Schedule schedule = comment.getSchedule();

        commentRepository.delete(comment);

        schedule.decreaseCommentCount();

        scheduleRepository.save(schedule);
    }
}
