package com.example.service.impl;

import com.example.mapper.SourceMapper;
import com.example.pojo.Source;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SourceService {

    @Autowired
    SourceMapper sourceMapper;

    public List<Source> getTopSources() {
        return sourceMapper.getTopSources();
    }
}