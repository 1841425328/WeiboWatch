package com.example.mapper;

import com.example.pojo.BlogMessage;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BlogMessageMapper {
    List<BlogMessage> getTopFivePopularBlogs();
}
