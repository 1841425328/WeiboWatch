package com.example.mapper;

import com.example.pojo.MediaNonMediaPostCountResult;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BlogPostMapper {
    List<MediaNonMediaPostCountResult> getMediaNonMediaPostCount();
}