package com.example.controller;

import com.example.pojo.MediaNonMediaPostCountResult;
import com.example.service.impl.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BlogPostController {

    @Autowired
    private BlogPostService blogPostService;

    @GetMapping("/post-count")
    public List<MediaNonMediaPostCountResult> getPostCount() {
        return blogPostService.getMediaNonMediaPostCount();
    }

}
