package com.example.service.impl;

import com.example.pojo.Top;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.mapper.TopMapper;

import java.util.List;


@Service
public class TopService {

    @Autowired
    TopMapper topMapper;

    public List<Top> getAllTops() {
        return topMapper.getAllTops();
    }
}
