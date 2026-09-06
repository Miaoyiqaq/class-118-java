package org.example.bookdemo.advice;

import org.example.bookdemo.model.Result;
import org.jspecify.annotations.Nullable;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import tools.jackson.databind.ObjectMapper;

@ControllerAdvice
public class ResponseAdvice implements ResponseBodyAdvice {
    ObjectMapper objectMapper = new ObjectMapper();
    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        //返回true 执行beforeBodyWrite方法

        return true;
    }

    @Override
    public @Nullable Object beforeBodyWrite(@Nullable Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        //body: 以目标方法返回的结果
        if(body instanceof Result<?>){//若方法返回值为Result<?>类型,则不进行类型转换
            return body;
        }
        if(body instanceof String){
            Result result = Result.success(body);
            return objectMapper.writeValueAsString(result);
        }
        return Result.success(body);
    }
}
