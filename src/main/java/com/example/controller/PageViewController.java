package com.example.controller;

import com.example.pojo.PageView;
import com.example.service.impl.PageViewService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PageViewController {

    private final PageViewService pageViewService;

    // 构造函数注入PageViewService
    public PageViewController(PageViewService pageViewService) {
        this.pageViewService = pageViewService;
    }

    // 处理PV和UV跟踪的POST请求
    @PostMapping("/track")
    public ResponseEntity<Void> trackPageView(@RequestBody PageView pageView) {
        pageViewService.savePageView(pageView);
        return ResponseEntity.ok().build();
    }
    // 提供一个端点来获取所有页面浏览数据
/*    @GetMapping("/pageViews")
    public ResponseEntity<List<PageView>> getAllPageViews() {
        List<PageView> pageViews = pageViewService.getPageViewData();
        return ResponseEntity.ok(pageViews);
    }*/

    // 提供一个端点来统计特定页面的PV
    @GetMapping("/pageViews/count")
    public ResponseEntity<Long> countPageViewsByPageUrl(@RequestParam String pageUrl) {
        long count = pageViewService.countPageViewsByPageUrl(pageUrl);
        return ResponseEntity.ok(count);
    }
}
