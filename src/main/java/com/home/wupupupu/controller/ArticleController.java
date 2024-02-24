package com.home.wupupupu.controller;

import com.home.wupupupu.pojo.Result;
import com.home.wupupupu.util.JWTUtil;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ArticleController {
    @PostMapping("list")
    public Result allArticle(@RequestHeader(name = "Authorization") String token, HttpServletResponse response){
//        try {
//            Map<String,Object> claims= JWTUtil.parseToken(token);
            return Result.success("文章所有数据。。。。");

//        }catch (Exception e){
//            response.setStatus(401);
//            return Result.error("未登入");
//        }
    }
}
