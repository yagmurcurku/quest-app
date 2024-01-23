package com.project.questapp.controllers;

import com.project.questapp.entities.Post;
import com.project.questapp.services.abstracts.PostService;
import com.project.questapp.services.dtos.requests.Post.PostCreateRequest;
import com.project.questapp.services.dtos.requests.Post.PostUpdateRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posts")
@AllArgsConstructor
public class PostController {

    private PostService postService;

    @GetMapping
    public List<Post>  getAllPosts(@RequestParam Optional<Long> userId) {
        return postService.getAllPosts(userId);
    }

    @GetMapping("/{postId}")
    public Post getPostById(@PathVariable Long postId) {
        return postService.getPostById(postId);
    }

    @PostMapping
    public void addPost(@RequestBody PostCreateRequest postCreateRequest) {
        postService.addPost(postCreateRequest);
    }

    @PutMapping()
    public void updatePost(@RequestBody PostUpdateRequest postUpdateRequest) {
        postService.updatePost(postUpdateRequest);
    }

    @DeleteMapping("/{postId}")
    public void deletePost(@PathVariable Long postId) {
        postService.deletePost(postId);
    }

}
