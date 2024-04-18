package com.home.wupupupu.controller;

import com.home.wupupupu.pojo.Result;
import com.home.wupupupu.util.JwtUtil;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/article")
public class ArticleController {
    @PostMapping("/list")
    public Result allArticle(@RequestHeader(name = "Authorization") String token, HttpServletResponse response){
        try {
            System.out.println(token);
            JwtUtil.parseToken(token);
            return Result.success("ALL Article");
        }catch (Exception e){
            response.setStatus(401);
            e.printStackTrace();
            return Result.error("未登入");
        }


    }
}
