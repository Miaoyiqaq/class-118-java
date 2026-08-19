package org.example.mybatisdemo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.mybatisdemo.model.ArticleInfo;
@Mapper
public interface ArticleInfoMapper {
    ArticleInfo getArticleInfoById(Integer articleId);

}
