package com.anma.js.blogs.sbjsblogs.config;

import com.anma.js.blogs.sbjsblogs.BlogRepository;
import com.anma.js.blogs.sbjsblogs.models.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.UUID;

@Component
public class Bootstrap implements CommandLineRunner {

    private final BlogRepository blogRepository;

    @Autowired
    public Bootstrap(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadData();
    }

    private void loadData() {
        Blog blog1 = Blog.builder()
                .id(UUID.randomUUID())
                .body("lorem asd asd asd asd asd asd asd asd ")
                .creationDate(LocalDate.now())
                .build();
        blogRepository.save(blog1);
    }
}
