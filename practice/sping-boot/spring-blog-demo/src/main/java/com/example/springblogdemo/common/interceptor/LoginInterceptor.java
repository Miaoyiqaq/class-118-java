package com.example.springblogdemo.common.interceptor;

import com.example.springblogdemo.common.util.JwtUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Slf4j
@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //使用response需要设置编码
        response.setContentType("application/json;charset=utf-8");
        //从Header中获取token
        String token = request.getHeader("User-Token");
        log.info("获取到token:{}", token);
        Claims claims = JwtUtils.parseJwt(token);
        if(claims == null) {
            log.warn("token校验失败:{}", token);
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
//            response.getOutputStream().write();
            return false;
        }
        log.info("token用户: id={}, name={}", claims.get("id"), claims.get("name"));
        //
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }
}
