package com.example.service;

import com.example.entity.Content;

import java.util.List;

public interface ContentService {
    List<Content> findContentList();
    int insertSelective(Content content);
}
