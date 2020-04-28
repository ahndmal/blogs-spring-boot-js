package com.anma.js.blogs.sbjsblogs.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "blogs")
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "blog_id")
    private Long id;

    @OneToMany(mappedBy = "blog")
    List<Comment> comments;

    private String title;
    private String author;
    private String body;
    private LocalDate creationDate = LocalDate.now();
}
