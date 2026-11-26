package org.example.product.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.product.api.ProductInterface;
import org.example.product.model.ProductInfo;
import org.example.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/product")
public class ProductController implements ProductInterface {
    @Autowired
    private ProductService productService;
    @RequestMapping("/{productId}")
    public ProductInfo getProductInfoById(@PathVariable("productId") Integer productId) {
        log.info("接受参数:{}", productId);
        return productService.selectProductInfoById(productId);
    }
    @RequestMapping("/p1")
    public String p1(Integer id) {
        return "product-service 接收到参数:" + id;
    }
    @RequestMapping("/p2")
    public String p2(Integer id, String name) {
        return "product-service 接收到参数id:" + id + "接收到参数name:" + name;
    }
    @RequestMapping("/p3")
    public String p3(ProductInfo productInfo) {
        return "product-service 接收到对象:" + productInfo.toString();
    }
    @RequestMapping("/p4")
    public String p4(@RequestBody ProductInfo productInfo) {
        return "product-service 接收到对象:" + productInfo.toString();
    }
}
