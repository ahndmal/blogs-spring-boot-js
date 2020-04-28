package com.anma.js.blogs.sbjsblogs.rest.api.v1;

import com.anma.js.blogs.sbjsblogs.repositorie.BlogRepository;
import com.anma.js.blogs.sbjsblogs.models.Blog;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(HttpStatus.CREATED)
    public Blog createBlog(@RequestBody Blog blog) {
        return blogRepository.save(blog);
    }
}
