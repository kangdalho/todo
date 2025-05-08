package com.example.todo.service;


import com.example.todo.dto.response.ScheduleResponseDto;
import com.example.todo.entity.Comment;
import com.example.todo.entity.Schedule;
import com.example.todo.repository.CommentRepository;
import com.example.todo.repository.ScheduleRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final CommentRepository commentRepository;

    //일정 생성
    public ScheduleResponseDto create(String writerId, String title, String content) {

        Schedule schedule = new Schedule(writerId, title, content);

        Schedule saved= scheduleRepository.save(schedule);
        //반한된 saved 객체 데이터 바로 추출하여 사용
        return new ScheduleResponseDto(saved.getId(), saved.getWriterId(), saved.getTitle(), saved.getContent(),saved.getCommentCount());

    }
    //일정 전체 조회
    public List<ScheduleResponseDto> findAll() {

        List<ScheduleResponseDto> schedules = scheduleRepository.findAll()
                .stream() //순차적으로 데이터를 처리할 수 있음
                .map(ScheduleResponseDto::toDto) //Schedule을 ScheduleResponseDto로 변환 (필요한 데이터만 응답으로 보내려고)
                .toList(); // stream 결과를 다시 리스트로 반환

        if (schedules.isEmpty()) {
            throw new RuntimeException("일정이 존재하지 않습니다");
        }
        return schedules;

    }
    //일정 단건 조회
    public ScheduleResponseDto findById(Long scheduleId) {

        Schedule schedule = scheduleRepository.findByIdOrElseThrow(scheduleId);

        List<Comment> commentList = commentRepository.findByScheduleIdOrderByCreatedAtAsc(scheduleId);

        return ScheduleResponseDto.toDto(schedule,commentList);
    }
    //일정 수정
    @Transactional
    public ScheduleResponseDto update(Long scheduleId, String title, String content) {

        Schedule schedule = scheduleRepository.findByIdOrElseThrow(scheduleId);

        schedule.update(title, content);

        return new ScheduleResponseDto(schedule.getId(), schedule.getWriterId(), schedule.getTitle(), schedule.getContent(),schedule.getCommentCount());
    }
    //일정 삭제
    public void delete(Long scheduleId) {

        Schedule schedule = scheduleRepository.findByIdOrElseThrow(scheduleId);

        scheduleRepository.delete(schedule);
    }
}

