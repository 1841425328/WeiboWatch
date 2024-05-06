package com.example.service.impl;

import com.example.mapper.BloggerMapper;
import com.example.pojo.Blogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BloggerService {
    @Autowired
    private BloggerMapper bloggerMapper;

    public List<Blogger> getTop10Bloggers() {
        return bloggerMapper.getTop10Bloggers();
    }
}
