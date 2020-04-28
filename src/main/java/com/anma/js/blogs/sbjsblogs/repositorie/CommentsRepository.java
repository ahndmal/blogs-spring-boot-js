package com.anma.js.blogs.sbjsblogs.repositorie;

import com.anma.js.blogs.sbjsblogs.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CommentsRepository extends JpaRepository<Comment, Long> {
}
