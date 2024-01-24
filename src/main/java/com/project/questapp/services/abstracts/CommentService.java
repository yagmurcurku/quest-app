package com.project.questapp.services.abstracts;

import com.project.questapp.entities.Comment;
import com.project.questapp.services.dtos.requests.Comment.CommentCreateRequest;
import com.project.questapp.services.dtos.requests.Comment.CommentUpdateRequest;

import java.util.List;
import java.util.Optional;

public interface CommentService {

    List<Comment> getAllComments(Optional<Long> userId, Optional<Long> postId);
    Comment getCommentById(Long id);
    void addComment(CommentCreateRequest commentCreateRequest);
    void updateComment(CommentUpdateRequest commentUpdateRequest);
    void deleteComment(Long id);

}
