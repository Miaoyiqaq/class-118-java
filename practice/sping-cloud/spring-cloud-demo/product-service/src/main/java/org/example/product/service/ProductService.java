package org.example.product.service;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.product.mapper.ProductMapper;
import org.example.product.model.ProductInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private ProductMapper productMapper;
    public ProductInfo selectProductInfoById(Integer id) {
        return productMapper.selectProductInfoById(id);
    }
}
