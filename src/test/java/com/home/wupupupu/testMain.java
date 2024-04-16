package com.home.wupupupu;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.home.wupupupu.util.MD5Util;
import org.junit.jupiter.api.Test;
import com.home.wupupupu.util.jwtUtil;
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
        String token=jwtUtil.getToken(claims);
        System.out.println(token);
        Map<String,Object> claims2;

        claims2=jwtUtil.parseToken(token);
        System.out.println(claims2.get("id"));
    }
}
