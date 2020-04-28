package com.anma.js.blogs.sbjsblogs.controllers;

import com.anma.js.blogs.sbjsblogs.BlogRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@Controller
@RequestMapping("/blogs")
public class BlogController {

    private final BlogRepository blogRepository;

    public BlogController(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    @GetMapping
    public String blogs(Model model) {
        model.addAttribute("blogs", blogRepository.findAll());
        return "blogs";
    }

    @GetMapping("/{blogId}")
    public String getBlogById(@PathVariable UUID blogId, Model model) {
        model.addAttribute("blog", blogRepository.findById(blogId).get());
        return "blog";
    }

}
