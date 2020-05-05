package com.anma.js.blogs.sbjsblogs.rest.api.v1;

import com.anma.js.blogs.sbjsblogs.exceptions.ResourseNotFoundException;
import com.anma.js.blogs.sbjsblogs.models.Comment;
import com.anma.js.blogs.sbjsblogs.repositorie.BlogRepository;
import com.anma.js.blogs.sbjsblogs.repositorie.CommentsRepository;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Log
public class CommentsRestController {

    private final CommentsRepository commentsRepository;
    private final BlogRepository blogRepository;

    public CommentsRestController(CommentsRepository commentsRepository,
                                  BlogRepository blogRepository) {
        this.commentsRepository = commentsRepository;
        this.blogRepository = blogRepository;
    }

    @GetMapping("/rest/api/v1/blogs/{blogId}/comments")
    @ResponseStatus(HttpStatus.OK)
    public List<Comment> getComments(@PathVariable Long blogId) {
        return blogRepository.findById(blogId).get().getComments();
    }

    @PostMapping("/rest/api/v1/blogs/{blogId}/comments")
    @ResponseStatus(HttpStatus.CREATED)
    public Comment createComments(@PathVariable Long blogId, @RequestBody Comment comment) {
        comment.setBlog(blogRepository.findById(blogId).get());
        return commentsRepository.save(comment);
    }

    @PatchMapping("/rest/api/v1/blogs/{blogId}/comments/{commentId}")
    public Comment patchComment(@RequestBody Comment commentDetails, @PathVariable long commentId) {
        Comment comment = commentsRepository.findById(commentId).orElseThrow(()-> new ResourseNotFoundException("Comment", "id", commentId));
        comment.setBody(commentDetails.getBody());
        return commentsRepository.save(comment);
    }

    @DeleteMapping("/rest/api/v1/blogs/{blogId}/comments/{commentId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteComment(@PathVariable long blogId, @PathVariable long commentId) {
        log.info("********* Deleting comment " + commentId);
        commentsRepository.delete(commentsRepository.findById(commentId).get());
        log.info("********* Comment deleted");
    }
}
