package com.example.controller;

import com.example.pojo.BlogMessage;
import com.example.service.impl.BlogMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BlogMessageController {

    @Autowired
    private BlogMessageService blogMessageService;

    @GetMapping("/top5")
    public List<BlogMessage> getTopFivePopularBlogs() {
        return blogMessageService.getTopFivePopularBlogs();
    }
}