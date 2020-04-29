package com.anma.js.blogs.sbjsblogs.rest.api.v1;

import com.anma.js.blogs.sbjsblogs.models.Comment;
import com.anma.js.blogs.sbjsblogs.repositorie.BlogRepository;
import com.anma.js.blogs.sbjsblogs.repositorie.CommentsRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class CommentsRestController {

    private final CommentsRepository commentsRepository;
    private final BlogRepository blogRepository;

    public CommentsRestController(CommentsRepository commentsRepository,
                                  BlogRepository blogRepository) {
        this.commentsRepository = commentsRepository;
        this.blogRepository = blogRepository;
    }

    @GetMapping("/rest/api/v1/blogs/{blogId}/comments")
    public List<Comment> getComments(@PathVariable Long blogId) {
        return blogRepository.findById(blogId).get().getComments();
    }

    @PostMapping("/rest/api/v1/blogs/{blogId}/comments")
    public Comment createComments(@PathVariable Long blogId, @RequestBody Comment comment) {
        comment.setBlog(blogRepository.findById(blogId).get());
        return commentsRepository.save(comment);
    }
}
