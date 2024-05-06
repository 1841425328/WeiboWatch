package com.example.controller;

import com.example.pojo.WeiboResult;
import com.example.service.impl.WeiboResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WeiboResultController {

    private final WeiboResultService weiboResultService;

    @Autowired
    public WeiboResultController(WeiboResultService weiboResultService) {
        this.weiboResultService = weiboResultService;
    }

    @GetMapping("/predictions")
    public List<WeiboResult> findAll() {
        return weiboResultService.findAll();
    }
}