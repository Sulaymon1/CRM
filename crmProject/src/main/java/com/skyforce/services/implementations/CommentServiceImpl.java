package com.skyforce.services.implementations;

import com.skyforce.models.Comment;
import com.skyforce.repositories.CommentRepository;
import com.skyforce.services.interfaces.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Sulaymon on 25.03.2018.
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository repository;

    @Override
    public List<Comment> getAllComments(Long id) {
        return repository.findAllByMemberId(id);
    }

    @Override
    public void addNewComment(Comment comment) {
        repository.save(comment);
    }
}
