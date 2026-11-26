package org.example.product.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope//启用热更新
@RestController
public class NacosController {
    @Value("${nacos.config}")
    private String nacosConfig;
    @RequestMapping("/getConfig")
    public String getNacosConfig() {
        return "获取到nacos配置nacos.config:" + nacosConfig;
    }
}
