package com.project.questapp.services.abstracts;

import com.project.questapp.entities.Post;
import com.project.questapp.services.dtos.requests.Post.PostCreateRequest;
import com.project.questapp.services.dtos.requests.Post.PostUpdateRequest;

import java.util.List;
import java.util.Optional;

public interface PostService {

    List<Post> getAllPosts(Optional<Long> userId);
    Post getPostById(Long postId);
    void addPost(PostCreateRequest postCreateRequest);
    void updatePost(PostUpdateRequest postUpdateRequest);
    void deletePost(Long postId);

}
