package com.project.questapp.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "posts")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {

    @Id
    Long id;

    Long userId;
    String title;

    @Lob
    @Column(columnDefinition = "text")
    String text;

}
