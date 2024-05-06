package com.example.pojo;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "page_view")
public class PageView {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String pageUrl;

    private String visitorId;

    @Column(name = "timestamp")
    private LocalDateTime timestamp;
}
