package com.example.todo.repository;



import com.example.todo.entity.Reply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;


import java.util.List;

public interface ReplyRepository extends JpaRepository<Reply, Long> {

    default Reply findByIdOrElseThrow(Long id) {
        return findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id = " + id));
    }

    List<Reply> findByCommentIdOrderByCreatedAtAsc(Long commentId);

}
