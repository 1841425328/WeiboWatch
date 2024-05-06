package com.example.mapper;

import com.example.pojo.Top;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface TopMapper {
    List<Top> getAllTops();
}
