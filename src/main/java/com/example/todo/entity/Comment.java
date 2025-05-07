package com.example.todo.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "comments")
@Getter
@NoArgsConstructor
public class Comment extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "schedule_id")
    private Schedule schedule;

    @Column(nullable = false)
    private String writerId;

    @Column(nullable = false)
    private String content;

    public Comment(Schedule schedule, String writerId, String content) {
        this.schedule = schedule;
        this.writerId = writerId;
        this.content = content;
    }

    public void update(String newContent) {
        this.content = newContent;
    }
}
