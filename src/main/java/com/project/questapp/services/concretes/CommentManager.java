package com.project.questapp.services.concretes;

import com.project.questapp.entities.Comment;
import com.project.questapp.entities.Post;
import com.project.questapp.entities.User;
import com.project.questapp.repos.CommentRepository;
import com.project.questapp.services.abstracts.CommentService;
import com.project.questapp.services.abstracts.PostService;
import com.project.questapp.services.abstracts.UserService;
import com.project.questapp.services.dtos.requests.Comment.CommentCreateRequest;
import com.project.questapp.services.dtos.requests.Comment.CommentUpdateRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CommentManager implements CommentService {

    private CommentRepository commentRepository;
    private UserService userService;
    private PostService postService;

    @Override
    public List<Comment> getAllComments(Optional<Long> userId, Optional<Long> postId) {
        if (userId.isPresent()) {
            return commentRepository.findByUserId(userId.get());
        } else if (postId.isPresent()) {
            return commentRepository.findByPostId(postId.get());
        }
        return commentRepository.findAll();
    }

    @Override
    public Comment getCommentById(Long id) {
        return commentRepository.findById(id).orElseThrow();
    }

    @Override
    public void addComment(CommentCreateRequest commentCreateRequest) {
        User user = userService.getUserById(commentCreateRequest.getUserId());
        Post post = postService.getPostById(commentCreateRequest.getPostId());
        if (user == null || post == null) {
            throw new RuntimeException("no found user or post");
        }
        Comment comment = new Comment();
        comment.setUser(user);
        comment.setPost(post);
        comment.setText(commentCreateRequest.getText());
        commentRepository.save(comment);
    }

    @Override
    public void updateComment(CommentUpdateRequest commentUpdateRequest) {
        Comment comment = commentRepository.findById(commentUpdateRequest.getId()).orElseThrow();
        comment.setText(commentUpdateRequest.getText());
        commentRepository.save(comment);
    }

    @Override
    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }

}
