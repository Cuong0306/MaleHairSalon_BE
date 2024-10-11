package com.BE.controller;

import com.BE.model.entity.Comment;
import com.BE.model.request.CommentRequest;
import com.BE.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
@CrossOrigin("*")
public class CommentController {
    @Autowired
    CommentService commentService;

    @PostMapping("/create")
    public ResponseEntity create(@RequestBody CommentRequest commentRequest) {
        Comment newComment = commentService.create(commentRequest);
        return ResponseEntity.ok(newComment);
    }

    @GetMapping("/getall")
    public ResponseEntity getAll() {
        List<Comment> comments = commentService.getAllComments();
        return ResponseEntity.ok(comments);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable long id, @RequestBody CommentRequest commentRequest) {
        Comment updatedComment = commentService.update(id, commentRequest);
        return ResponseEntity.ok(updatedComment);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable long id) {
        Comment deletedComment = commentService.delete(id);
        return ResponseEntity.ok(deletedComment);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity getCommentById(@PathVariable long id) {
        Comment comment = commentService.getCommentById(id);
        return ResponseEntity.ok(comment);
    }
}