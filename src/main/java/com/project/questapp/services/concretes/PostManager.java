package com.project.questapp.services.concretes;

import com.project.questapp.core.utilities.mappers.ModelMapperService;
import com.project.questapp.entities.Post;
import com.project.questapp.entities.User;
import com.project.questapp.repos.PostRepository;
import com.project.questapp.services.abstracts.PostService;
import com.project.questapp.services.abstracts.UserService;
import com.project.questapp.services.dtos.requests.Post.PostCreateRequest;
import com.project.questapp.services.dtos.requests.Post.PostUpdateRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PostManager implements PostService {

    private PostRepository postRepository;
    private UserService userService;
    private ModelMapperService mapperService;

    @Override
    public List<Post> getAllPosts(Optional<Long> userId) {
        if (userId.isPresent()) {
            return postRepository.findByUserId(userId.get());
        }
        return postRepository.findAll();
    }

    @Override
    public Post getPostById(Long postId) {
        return postRepository.findById(postId).orElseThrow();
    }

    @Override
    public void addPost(PostCreateRequest postCreateRequest) {
        User user = userService.getUserById(postCreateRequest.getUserId());
        if(user == null) {
            throw new RuntimeException("not found user");
        }
        Post post = mapperService.forRequest().map(postCreateRequest, Post.class);
        postRepository.save(post);
    }

    @Override
    public void updatePost(PostUpdateRequest postUpdateRequest) {
        Post postToUpdate = postRepository.findById(postUpdateRequest.getId()).orElseThrow();
        postToUpdate.setTitle(postUpdateRequest.getTitle());
        postToUpdate.setText(postUpdateRequest.getText());
        postRepository.save(postToUpdate);
    }

    @Override
    public void deletePost(Long postId) {
        postRepository.deleteById(postId);
    }


}
