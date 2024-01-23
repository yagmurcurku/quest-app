package com.project.questapp.services.dtos.requests.Post;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostCreateRequest {

    Long id;
    String text;
    String title;
    Long userId;
}
