package com.project.questapp.services.abstracts;

import com.project.questapp.entities.Comment;
import com.project.questapp.services.dtos.requests.Comment.CommentCreateRequest;
import com.project.questapp.services.dtos.requests.Comment.CommentUpdateRequest;

import java.util.List;

public interface CommentService {

    List<Comment> getAllComments();
    Comment getCommentById();
    void addComment(CommentCreateRequest commentCreateRequest);
    void updateComment(CommentUpdateRequest commentUpdateRequest);
    void deleteComment(Long id);

}
