package org.example.product.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.product.model.ProductInfo;
import org.example.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper
public interface  ProductMapper {
    @Select("select * from product_detail where id = #{id}")
    ProductInfo selectProductInfoById(Integer id);
}
