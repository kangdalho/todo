package com.example.todo.repository;


import com.example.todo.entity.Reply;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface ReplyRepository extends JpaRepository<Reply, Long> {

    List<Reply> findByCommentIdOrderByCreatedAtAsc(Long commentId);

}
