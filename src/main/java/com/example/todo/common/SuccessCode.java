package com.example.todo.common;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum SuccessCode {


    SCHEDULE_CREATE_SUCCESS(201, HttpStatus.CREATED, "일정을 생성하였습니다."),
    SCHEDULE_FIND_SUCCESS(200, HttpStatus.OK, "일정을 조회하였습니다."),
    SCHEDULE_UPDATE_SUCCESS(200, HttpStatus.OK, "일정을 수정하였습니다."),
    SCHEDULE_DELETE_SUCCESS(200, HttpStatus.OK, "일정을 삭제하였습니다."),

    COMMENT_CREATE_SUCCESS(201, HttpStatus.CREATED, "댓글이 생성되었습니다."),
    COMMENT_FIND_SUCCESS(200, HttpStatus.OK, "댓글을 조회하였습니다."),
    COMMENT_UPDATE_SUCCESS(200, HttpStatus.OK, "댓글을 수정하였습니다."),
    COMMENT_DELETE_SUCCESS(200, HttpStatus.OK, "댓글을 삭제하였습니다."),


    REPLY_CREATE_SUCCESS(201, HttpStatus.CREATED, "대댓글이 생성되었습니다."),
    REPLY_FIND_SUCCESS(200, HttpStatus.OK, "대댓글을 조회하였습니다."),
    REPLY_UPDATE_SUCCESS(200,HttpStatus.OK,"대댓글을 수정하였습니다."),
    REPLY_DELETE_SUCCESS(200,HttpStatus.OK,"대댓글을 삭제하였습니다.");


    private final Integer code;

    private final HttpStatus httpStatus;

    private final String message;

    SuccessCode(Integer code, HttpStatus httpStatus, String message) {
        this.code = code;
        this.httpStatus = httpStatus;
        this.message = message;
    }
}
