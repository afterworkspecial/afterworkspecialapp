package com.afterworkspecial.afterworkspecial.repository;

import com.afterworkspecial.afterworkspecial.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
}
