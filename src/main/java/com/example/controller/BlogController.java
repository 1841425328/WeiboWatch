package com.example.controller;

import com.example.pojo.Blog;
import com.example.service.impl.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BlogController {

    @Autowired
    private BlogService blogService;

    @GetMapping("/keyword-stats")
    public ResponseEntity<List<Blog>> getKeywordStats() {
        List<Blog> keywordStats = blogService.getKeywordStats();
        return ResponseEntity.ok(keywordStats);
    }
}