package com.home.wupupupu.util;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.Date;
import java.util.Map;
import java.util.Objects;

public class JWTUtil {
    private static final String KEY="wupupupu";

    public static String getToken(Map<String, Object> claims) {
        return JWT.create()
                .withClaim("claims",claims)
                .withExpiresAt(new Date(System.currentTimeMillis()+1000*60*3))
                .sign(Algorithm.HMAC256(KEY));
    }
    public static Map<String,Object> parseToken(String token){
        return JWT.require(Algorithm.HMAC256(KEY))
                .build()
                .verify(token)
                .getClaim("claims")
                .asMap();
    }
}
