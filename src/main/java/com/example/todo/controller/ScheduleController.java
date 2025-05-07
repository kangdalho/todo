package com.example.todo.controller;


import com.example.todo.dto.request.CreateScheduleRequestDto;
import com.example.todo.dto.response.ScheduleResponseDto;
import com.example.todo.dto.request.UpdateScheduleRequestDto;
import com.example.todo.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // @Controller + @ResponseBody (객체롤 다시 JSON으로)
@RequestMapping("/schedules") // prefix 선언
@RequiredArgsConstructor // final 필드 생성자 자동 생성
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping
    public ResponseEntity<ScheduleResponseDto> create(
            @RequestBody CreateScheduleRequestDto requestDto
    ) {
        ScheduleResponseDto scheduleResponseDto = scheduleService.create(
                requestDto.getWriterId(), requestDto.getTitle(), requestDto.getContent()
        );
        return new ResponseEntity<>(scheduleResponseDto, HttpStatus.CREATED);

    }

    @GetMapping
    public ResponseEntity<List<ScheduleResponseDto>> findAll() {

        List<ScheduleResponseDto> scheduleList = scheduleService.findAll();

        return new ResponseEntity<>(scheduleList, HttpStatus.OK);
    }

    @GetMapping("/{scheduleId}")
    public ResponseEntity<ScheduleResponseDto> findById(
            @PathVariable Long scheduleId
    ) {
        ScheduleResponseDto findSchedule = scheduleService.findById(scheduleId);

        return new ResponseEntity<>(findSchedule, HttpStatus.OK);

    }

    @PatchMapping("/{scheduleId}")
    public ResponseEntity<ScheduleResponseDto> update(
            @PathVariable Long scheduleId,
            @RequestBody UpdateScheduleRequestDto requestDto
    ) {
        ScheduleResponseDto updated = scheduleService.update(scheduleId,requestDto.getTitle(), requestDto.getContent());

        return new ResponseEntity<>(updated,HttpStatus.OK);
    }

    @DeleteMapping("/{scheduleId}")
    public ResponseEntity<Void> delete(
            @PathVariable Long scheduleId
    ) {
        scheduleService.delete(scheduleId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
