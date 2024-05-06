package com.example.service.impl;

import com.example.pojo.PageView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PageViewRepository extends JpaRepository<PageView, Long> {

    // 根据页面URL查询PageView对象
    List<PageView> findByPageUrl(String pageUrl);

    // 根据访客ID查询PageView对象
    List<PageView> findByVisitorId(String visitorId);

    // 根据时间戳范围查询PageView对象
    List<PageView> findByTimestampBetween(LocalDateTime start, LocalDateTime end);

    // 自定义查询，例如统计特定页面的访问量
    long countByPageUrl(String pageUrl);

    // 自定义查询，例如统计特定时间范围内的访问量
    long countByTimestampBetween(LocalDateTime start, LocalDateTime end);

}


