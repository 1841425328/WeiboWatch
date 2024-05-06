package com.example.controller;

import com.example.pojo.Source;
import com.example.service.impl.SourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class SourceController {

    @Autowired
    private SourceService sourceService;

    @GetMapping("/topSources")
    public ResponseEntity<List<Map<String, Object>>> getTopSources() {
        List<Map<String, Object>> result = new ArrayList<>();
        List<Source> topSources = sourceService.getTopSources();
        for (Source source : topSources) {
            Map<String, Object> sourceMap = new HashMap<>();
            sourceMap.put("source", source.getSource());
            sourceMap.put("count", source.getCount());
            result.add(sourceMap);
        }
        return ResponseEntity.ok(result);
    }
}
