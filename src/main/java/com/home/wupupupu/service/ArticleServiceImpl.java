package com.home.wupupupu.service;

import com.home.wupupupu.mapper.ArticleMapper;
import com.home.wupupupu.pojo.Article;
import com.home.wupupupu.util.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Map;

@Service
public class ArticleServiceImpl implements ArticleService{
    @Autowired
    ArticleMapper articleMapper;
    @Override
    public void addArticle(Article article) {
        article.setCreateTime(Timestamp.valueOf(LocalDateTime.now()));
        article.setUpdateTime(Timestamp.valueOf(LocalDateTime.now()));
        Map<String,Object> map = ThreadLocalUtil.get();
        int userId=(int) map.get("id");
        article.setCreateUser(userId);
        articleMapper.addArticle(article);
    }
}
