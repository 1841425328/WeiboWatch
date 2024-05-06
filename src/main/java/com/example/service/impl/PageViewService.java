package com.example.service.impl;

import com.example.pojo.PageView;
import com.example.service.impl.PageViewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PageViewService {

    @Autowired
    private PageViewRepository pageViewRepository;

    // 保存PageView对象
    public void savePageView(PageView pageView) {
        pageViewRepository.save(pageView);
    }

    // 根据页面URL查询PageView对象
    public List<PageView> getPageViewsByPageUrl(String pageUrl) {
        return pageViewRepository.findByPageUrl(pageUrl);
    }

    // 根据统计特定页面的访问量
    public long countPageViewsByPageUrl(String pageUrl) {
        return pageViewRepository.countByPageUrl(pageUrl);
    }
}



