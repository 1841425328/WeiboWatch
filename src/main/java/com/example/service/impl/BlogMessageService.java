package com.example.service.impl;

import com.example.mapper.BlogMessageMapper;
import com.example.pojo.BlogMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BlogMessageService {

    @Autowired
    BlogMessageMapper blogMessageMapper;

    public List<BlogMessage> getTopFivePopularBlogs() {
        return blogMessageMapper.getTopFivePopularBlogs();
    }
}

