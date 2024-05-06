package com.example.mapper;

import com.example.pojo.Blog;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface BlogMapper {
    List<Blog> getKeywordStats();
}