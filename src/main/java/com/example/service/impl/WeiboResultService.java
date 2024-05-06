package com.example.service.impl;

import com.example.mapper.WeiboResultMapper;
import com.example.pojo.WeiboResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeiboResultService {
    @Autowired
    WeiboResultMapper weiboResultMapper;

    public List<WeiboResult> findAll() {
        return weiboResultMapper.findAll();
    }
}