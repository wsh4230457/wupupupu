package com.home.wupupupu.controller;

import com.home.wupupupu.pojo.Article;
import com.home.wupupupu.pojo.Result;
import com.home.wupupupu.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    ArticleService articleService;
    @PostMapping("/list")
    public Result allArticle(){

            return Result.success("ALL Article");
    }
    @PostMapping("addArticle")
    public Result addArticle(@RequestBody @Validated(Article.add.class) Article article){
        articleService.addArticle(article);
        return Result.success();
    }
}
