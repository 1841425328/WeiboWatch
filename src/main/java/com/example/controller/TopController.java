package com.example.controller;

import com.example.pojo.Top;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.service.impl.TopService;

import java.util.List;

@Controller
public class TopController {

    @Autowired
    private TopService topService;

    @GetMapping("/tops")
    @ResponseBody
    public ResponseEntity<List<Top>> getTopItems() {
        // 获取热门数据
        List<Top> topItems = topService.getAllTops();

        // 如果获取到数据，则返回成功响应
        if (!topItems.isEmpty()) {
            return new ResponseEntity<>(topItems, HttpStatus.OK);
        } else {
            // 如果没有获取到数据，则返回404状态码
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}