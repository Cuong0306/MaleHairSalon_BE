package com.BE.service;

import com.BE.exception.exceptions.NotFoundException;
import com.BE.model.entity.Comment;
import com.BE.model.request.CommentRequest;
import com.BE.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    CommentRepository commentRepository;

    public Comment create(CommentRequest commentRequest) {
        Comment comment = new Comment();
        comment.setContent(commentRequest.getContent());
        comment.setRating(commentRequest.getRating());
        // Set user, service, stylist, salon based on IDs
        // Assume methods to fetch these entities by ID exist
        return commentRepository.save(comment);
    }

    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    public Comment update(long id, CommentRequest commentRequest) {
        Comment existingComment = getCommentById(id);
        existingComment.setContent(commentRequest.getContent());
        existingComment.setRating(commentRequest.getRating());
        return commentRepository.save(existingComment);
    }

    public Comment delete(long id) {
        Comment existingComment = getCommentById(id);
        existingComment.setDeleted(true);
        return commentRepository.save(existingComment);
    }

    public Comment getCommentById(long id) {
        return commentRepository.findById(id);
    }
}