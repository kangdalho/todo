package com.example.todo.controller;


import com.example.todo.common.ApiResponseDto;
import com.example.todo.common.SuccessCode;
import com.example.todo.dto.request.CreateScheduleRequestDto;
import com.example.todo.dto.response.ScheduleResponseDto;
import com.example.todo.dto.request.UpdateScheduleRequestDto;
import com.example.todo.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // @Controller + @ResponseBody (객체롤 다시 JSON으로)
@RequestMapping("/schedules") // prefix 선언
@RequiredArgsConstructor // final 필드 생성자 자동 생성
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping
    public ResponseEntity<ApiResponseDto<ScheduleResponseDto>> create(
            @RequestBody CreateScheduleRequestDto requestDto
    ) {
        ScheduleResponseDto scheduleResponseDto = scheduleService.create(
                requestDto.getWriterId(), requestDto.getTitle(), requestDto.getContent()
        );
        return ResponseEntity.ok(ApiResponseDto.success(SuccessCode.SCHEDULE_CREATE_SUCCESS,scheduleResponseDto));

    }

    @GetMapping
    public ResponseEntity<ApiResponseDto<List<ScheduleResponseDto>>> findAll() {

        List<ScheduleResponseDto> scheduleList = scheduleService.findAll();

        return ResponseEntity.ok(ApiResponseDto.success(SuccessCode.SCHEDULE_FIND_SUCCESS,scheduleList));
    }

    @GetMapping("/{scheduleId}")
    public ResponseEntity<ApiResponseDto<ScheduleResponseDto>> findById(
            @PathVariable Long scheduleId
    ) {
        ScheduleResponseDto findSchedule = scheduleService.findById(scheduleId);

        return ResponseEntity.ok(ApiResponseDto.success(SuccessCode.SCHEDULE_FIND_SUCCESS,findSchedule));

    }

    @PatchMapping("/{scheduleId}")
    public ResponseEntity<ApiResponseDto<ScheduleResponseDto>> update(
            @PathVariable Long scheduleId,
            @RequestBody UpdateScheduleRequestDto requestDto
    ) {
        ScheduleResponseDto updated = scheduleService.update(scheduleId,requestDto.getTitle(), requestDto.getContent());

        return ResponseEntity.ok(ApiResponseDto.success(SuccessCode.SCHEDULE_UPDATE_SUCCESS,updated));
    }

    @DeleteMapping("/{scheduleId}")
    public ResponseEntity<ApiResponseDto<Void>> delete(
            @PathVariable Long scheduleId
    ) {
        scheduleService.delete(scheduleId);
        return ResponseEntity.ok(ApiResponseDto.success(SuccessCode.SCHEDULE_DELETE_SUCCESS,null));
    }

}
