package org.example.mybatisdemo.mapper;

import org.example.mybatisdemo.model.ArticleInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ArticleInfoMapperTest {

    @Autowired
    private ArticleInfoMapper articleInfoMapper;
    @Test
    void getArticleInfo() {
//        articleInfoMapper.getArticleInfoById(1);
        ArticleInfo articleInfo = articleInfoMapper.getArticleInfoById(1);
        System.out.println(articleInfo);
    }
}