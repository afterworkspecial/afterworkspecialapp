package com.afterworkspecial.afterworkspecial.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity(name = "whatsup")
public class Whatsup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private User user;
    private String text;
    private int likes;
    private LocalDateTime createdDate;
    @OneToMany
    private List<Comment> commentsList;
}
