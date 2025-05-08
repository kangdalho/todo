package com.example.todo.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "replies")
@Getter
@NoArgsConstructor
public class Reply extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "comment_id")
    private Comment comment;

    @Column(nullable = false)
    private String writerId;

    @Column(nullable = false)
    private String content;

    public Reply(Comment comment, String writerId, String content) {
        this.comment = comment;
        this.writerId = writerId;
        this.content = content;
    }

    public void update(String newContent) {
        this.content = newContent;
    }
}
