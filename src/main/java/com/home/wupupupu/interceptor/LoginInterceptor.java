package com.home.wupupupu.interceptor;

import com.home.wupupupu.util.JWTUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Map;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        try {
            Map<String,Object> claim= JWTUtil.parseToken(request.getHeader("Authorization"));
            return true;
        }catch (Exception e){
            response.setStatus(401);
            return false;
        }
    }
}
