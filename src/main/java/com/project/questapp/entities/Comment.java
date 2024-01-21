package com.project.questapp.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "comments")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {

    @Id
    Long id;

    Long postId;
    Long userId;

    @Lob
    @Column(columnDefinition = "text")
    String text;

}
