package com.example.todo.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "schedules")
@Getter
@NoArgsConstructor // 기본생성자 자동 생성
public class Schedule extends BaseEntity {

    @Id //고유키 엔티티 생성시 반드시 있어야 함
    @GeneratedValue(strategy = GenerationType.IDENTITY) // id값 자동으로 1씩 증가 시켜줌
    private Long id;

    @Column(nullable = false) //컬럼 null 불가
    private String writerId;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private int commentCount = 0;

    public Schedule(String writerId, String title, String content) {
        this.writerId = writerId;
        this.title = title;
        this.content = content;
    }
    // 일정 수정 메서드
    public void update(String newTitle, String newContent) {
        this.title = newTitle;
        this.content = newContent;
    }
    // 댓글 수 증가 메서드
    public void increaseCommentCount() {
        this.commentCount++;
    }
    // 댓글 수 감소 메서드
    public void decreaseCommentCount() {
        if (this.commentCount > 0) {
            this.commentCount--;
        }
    }
}
