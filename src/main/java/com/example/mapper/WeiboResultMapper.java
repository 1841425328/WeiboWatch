package com.example.mapper;


import com.example.pojo.WeiboResult;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WeiboResultMapper {
    // 这里可以定义一些自定义的查询方法，如果需要的话
    List<WeiboResult> findAll();
}