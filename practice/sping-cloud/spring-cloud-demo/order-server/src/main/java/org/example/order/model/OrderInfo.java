package org.example.order.model;

import lombok.Data;

import java.util.Date;

@Data
public class OrderInfo {
    private Integer id;//订单id
    private Integer userId;//用户id
    private Integer productId;//下单数量
    private Integer num;//实付款
    private Integer price;
    private Integer deleteFlag;
    private Date createTime;
    private Date updateTime;
    private ProductInfo productInfo;
}
