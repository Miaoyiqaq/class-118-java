package org.example.product.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.product.model.ProductInfo;

@Mapper
public interface  ProductMapper {
    @Select("select * from product_detail where id = #{id}")
    ProductInfo selectProductInfoById(Integer id);
}
