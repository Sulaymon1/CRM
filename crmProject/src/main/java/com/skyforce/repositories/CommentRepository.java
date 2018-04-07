package com.skyforce.repositories;

import com.skyforce.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Sulaymon on 25.03.2018.
 */
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByMemberId(Long id);
}
