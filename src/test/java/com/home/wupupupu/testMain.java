package com.home.wupupupu;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.home.wupupupu.pojo.Article;
import com.home.wupupupu.util.MD5Util;
import org.junit.jupiter.api.Test;
import com.home.wupupupu.util.JwtUtil;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class testMain {
    @Test
    void  test01(){

    }
    void contextLoads() {
        Map<String,Object> claims=new HashMap<>();
        claims.put("id",2);
        claims.put("username","wsh");
        String token=    JWT.create().
                withClaim("user",claims).
                withExpiresAt(new Date(System.currentTimeMillis()+1000*60*60*12)).
                sign(Algorithm.HMAC256("1234"));
        System.out.println(token);
        JWTVerifier verifier=JWT.require(Algorithm.HMAC256("1234")).build();
        DecodedJWT decodedJWT=verifier.verify(token);
        Map<String, Claim> clains2=decodedJWT.getClaims();
        Claim a=clains2.get("user");
        Map<String,Object>b=a.asMap();
        System.out.println(b.get("id")+""+b.get("username"));
    }
    @Test
    void md5Test(){
        String pas="12233";
        System.out.println(MD5Util.getMd5(pas));
    }
    @Test
    void jwt1(){
        Map<String,Object> claims=new HashMap<>();
        claims.put("id",1);
        claims.put("username","wsh");
        String token= JwtUtil.getToken(claims);
        String token2= "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJjbGFpbXMiOnsidXNlcm5hbWUiOiI0MjMwNDU3In0sImV4cCI6MTcxMzM2NTY5OH0.CE4figTSCLv0I3D8nxg73Dzb3GVuFuZ5MnQ9S6B__Gs";
        System.out.println(token);
        Map<String,Object> claims2;

        claims2= JwtUtil.parseToken(token2);
        System.out.println(claims2.get("username"));
    }
    @Test
    void time(){
        Article article=new Article();
        article.setCreateTime(Timestamp.valueOf(LocalDateTime.now()));
        System.out.println(article.getCreateTime());
    }

}
