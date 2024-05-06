package com.example.pojo;

import lombok.Data;

@Data
public class Blog {
    private String keyword;
    private int reposts_Count;
    private int comments_Count;
}