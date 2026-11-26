package org.example.product.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.product.model.ProductInfo;
import org.example.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/product")
public class ProductController {

    @Value("${server.port}")
    private String port;

    @Autowired
    private ProductService productService;
    @RequestMapping("/{productId}")
    public ProductInfo getProductInfoById(@PathVariable("productId") Integer productId) {
        log.info("端口:{}, 接收到参数:{}", port, productId);
        return productService.selectProductInfoById(productId);
    }
}
