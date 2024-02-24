package com.home.wupupupu.controller;

import com.home.wupupupu.pojo.Result;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArticleController {
    @PostMapping("list")
    public Result allArticle(){
        return Result.success();
    }
}
