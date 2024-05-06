package com.example.pojo;


import lombok.Data;

@Data
public class BlogMessage {
    private String keyword;

    private int reposts_count;

    private int likes_count;

    private int comments_count;

    private int search_volume;
}
