package com.example.mapper;

import com.example.pojo.Blogger;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BloggerMapper {
    @Select("SELECT blogger, SUM(likes_count) AS total_likes FROM blog GROUP BY blogger ORDER BY total_likes DESC LIMIT 10")
    List<Blogger> getTop10Bloggers();
}

