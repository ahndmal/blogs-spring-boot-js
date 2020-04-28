package com.anma.js.blogs.sbjsblogs.repositorie;

import com.anma.js.blogs.sbjsblogs.models.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BlogRepository extends JpaRepository<Blog, UUID> {

    Blog getBlogByAuthor(String author);
}
