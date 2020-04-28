package com.anma.js.blogs.sbjsblogs.rest.api;

import com.anma.js.blogs.sbjsblogs.BlogRepository;
import com.anma.js.blogs.sbjsblogs.models.Blog;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(BlogsRestController.REST_URL)
public class BlogsRestController {

    final static String REST_URL = "/rest/api/v1/blogs";

    private final BlogRepository blogRepository;

    public BlogsRestController(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    @GetMapping
    public List<Blog> getAllBlogs() {
        return blogRepository.findAll();
    }
}
