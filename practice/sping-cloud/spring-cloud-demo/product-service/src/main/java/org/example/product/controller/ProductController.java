package org.example.product.controller;

import org.example.product.model.ProductInfo;
import org.example.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @RequestMapping("/{productId}")
    public ProductInfo getProductInfoById(@PathVariable("productId") Integer productId) {
        return productService.selectProductInfoById(productId);
    }
}
