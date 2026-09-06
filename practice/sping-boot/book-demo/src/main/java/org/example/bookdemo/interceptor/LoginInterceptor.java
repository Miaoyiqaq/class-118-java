package org.example.bookdemo.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.example.bookdemo.model.Result;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import tools.jackson.databind.ObjectMapper;

@Slf4j
@Component
public class LoginInterceptor implements HandlerInterceptor {
    private ObjectMapper objectMapper = new ObjectMapper();
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("进行登录校验" + request.getRequestURI());
        response.setContentType("application/json;charset=UTF-8");
        HttpSession session = request.getSession(false);
        //校验登录
        if(session!=null && session.getAttribute("userName") != null){
            log.info("用户已登录");
            return true;
        }
        //拦截未登录
        log.warn("用户未登录" + request.getRequestURI());
        Result result = Result.unLogin();
        response.getOutputStream().write(objectMapper.writeValueAsBytes(result));
        response.setStatus(401);
        return false;
    }


//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
//        log.info("接口执行后返回");
//        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
//    }
//
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
//        log.info("视图渲染完成后返回");
//        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
//    }
}
