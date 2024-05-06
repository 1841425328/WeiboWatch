package com.example.service.impl;

import com.example.mapper.BlogPostMapper;
import com.example.pojo.MediaNonMediaPostCountResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogPostService {
    @Autowired
    BlogPostMapper blogPostMapper;

    public List<MediaNonMediaPostCountResult> getMediaNonMediaPostCount() {
        return blogPostMapper.getMediaNonMediaPostCount();
    }
}
