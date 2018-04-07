package com.skyforce.services.interfaces;

import com.skyforce.models.Comment;

import java.util.List;

/**
 * Created by Sulaymon on 25.03.2018.
 */
public interface CommentService {

    List<Comment> getAllComments(Long id);
    void addNewComment(Comment comment);
}
