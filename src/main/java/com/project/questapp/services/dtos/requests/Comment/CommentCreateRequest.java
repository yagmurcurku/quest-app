package com.project.questapp.services.dtos.requests.Comment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentCreateRequest {

    private Long postId;
    private Long userId;
    private String text;

}
