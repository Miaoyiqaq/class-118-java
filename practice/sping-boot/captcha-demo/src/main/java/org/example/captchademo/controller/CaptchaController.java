package org.example.captchademo.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import cn.hutool.core.lang.Console;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.captchademo.model.CaptchaProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;


@RestController
@RequestMapping("/captcha")
public class CaptchaController {
    private final static long VALID_MILLIS_TIME = 2 * 60 * 1000L;
    @Autowired
    private CaptchaProperties captchaProperties;
    @GetMapping("/getCaptcha")
    public void getCaptcha(HttpServletResponse response, HttpSession session) throws IOException {
        //定义图形验证码的长和宽
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(captchaProperties.getWidth(), captchaProperties.getHeight());

        String code = lineCaptcha.getCode();
        session.setAttribute(captchaProperties.getSession().getCode(), code);
        session.setAttribute(captchaProperties.getSession().getDate(), System.currentTimeMillis());


        //设置响应格式为jpeg
        response.setContentType("image/jpeg");
        //禁止浏览器缓存
        response.setHeader("Pragma", "No-cache");
        //图形验证码写出，写出到流
        lineCaptcha.write(response.getOutputStream());
        response.getOutputStream().close();
        //输出code
        Console.log(lineCaptcha.getCode());
    }
    @PostMapping("/check")
    public boolean verify(String captcha, HttpSession session) {
        if(!StringUtils.hasText(captcha)){
            return false;
        }
        String savedCode = (String)session.getAttribute(captchaProperties.getSession().getCode());
        long time = (long) session.getAttribute(captchaProperties.getSession().getDate());
        if(captcha.equalsIgnoreCase(savedCode)) {
            if(System.currentTimeMillis() - time < VALID_MILLIS_TIME) {
                return true;
            }
        }
        return false;
    }
}
