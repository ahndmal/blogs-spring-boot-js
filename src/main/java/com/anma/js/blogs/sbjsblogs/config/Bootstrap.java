package com.anma.js.blogs.sbjsblogs.config;

import com.anma.js.blogs.sbjsblogs.models.Blog;
import com.anma.js.blogs.sbjsblogs.models.Comment;
import com.anma.js.blogs.sbjsblogs.repositorie.BlogRepository;
import com.anma.js.blogs.sbjsblogs.repositorie.CommentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class Bootstrap implements CommandLineRunner {

    private final BlogRepository blogRepository;
    private final CommentsRepository commentsRepository;

    @Autowired
    public Bootstrap(BlogRepository blogRepository, CommentsRepository commentsRepository) {
        this.blogRepository = blogRepository;
        this.commentsRepository = commentsRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadBlogs();
        loadComments();
    }

    private void loadComments() {
        Comment comment1 = Comment.builder()
                .id(1L)
                .author("anma")
                .blog(blogRepository.getBlogByAuthor("Marc"))
                .body("Hello! First comment ...")
                .title("First comment")
                .creationDate(LocalDate.now())
                .build();
        commentsRepository.save(comment1);
    }

    private void loadBlogs() {

        Blog blog1 = Blog.builder()
                .id(1L)
                .title("Why you should try Svelte Intro to Svelte")
                .body("I recently came across Svelte again when I watched the stateofjs 2019. They received the \"Prediction Award\" which means they are \"awarded to an up-and-coming technology that might take over ")
                .creationDate(LocalDate.now())
                .author("Marc")
                .build();
        blogRepository.save(blog1);

        Blog blog2 = Blog.builder()
                .id(2L)
                .title("Launching Code Time 2.0")
                .body("We’re super excited to announce the launch of the next version of Code Time. Code Time provides automatic time tracking and coding metrics that help you improve—all for free. You can check us out on Product Hunt. ")
                .creationDate(LocalDate.now())
                .author("Geoff Stevens")
                .build();
        blogRepository.save(blog2);
    }
}
