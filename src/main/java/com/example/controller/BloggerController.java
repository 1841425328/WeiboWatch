package com.example.controller;

import com.example.pojo.Blogger;
import com.example.service.impl.BloggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BloggerController {
    @Autowired
    private BloggerService bloggerService;

    @GetMapping("/bloggerTop10")
    public List<Blogger> getTop10Bloggers() {
        return bloggerService.getTop10Bloggers();
    }
}

