package org.example.bookdemo.config;

import org.example.bookdemo.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class AppConfig implements WebMvcConfigurer {
    @Autowired
    private LoginInterceptor loginInterceptor;

    private List<String> excludePathPatterns = List.of(
            "/user/login",
            "/test/**",
            "/error",
            "/**/*.html",
            "/css/**",
            "/js/**",
            "/pic/**",
            "favicon.ico"
    );

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor).addPathPatterns("/**")
                .excludePathPatterns(excludePathPatterns);
    }
}
