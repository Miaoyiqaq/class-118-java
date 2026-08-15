package org.example.captchademo.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "spring.captcha")
@Data
public class CaptchaProperties {
    private int width;
    private int height;
    private Session session;
}
