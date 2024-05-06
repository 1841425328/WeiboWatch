package com.example.service.impl;

import com.example.mapper.BlogMapper;
import com.example.pojo.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService {

    @Autowired
    private BlogMapper blogMapper;

    public List<Blog> getKeywordStats() {
        return blogMapper.getKeywordStats();
    }
}