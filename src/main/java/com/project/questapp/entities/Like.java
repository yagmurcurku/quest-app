package com.project.questapp.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "p_likes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Like {

    @Id
    Long id;

    Long postId;
    Long userId;
}
