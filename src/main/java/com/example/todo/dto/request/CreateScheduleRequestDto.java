package com.example.todo.dto.request;



import lombok.Getter;

@Getter
public class CreateScheduleRequestDto {

    private final String writerId;

    private final String title;

    private final String content;

    public CreateScheduleRequestDto(String writerId, String title, String content) {
        this.writerId = writerId;
        this.title = title;
        this.content = content;
    }
}
