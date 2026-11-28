package org.example.order.service;

import org.example.order.api.ProductApi;
import org.example.order.mapper.OrderMapper;
import org.example.order.model.OrderInfo;
import org.example.product.model.ProductInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private ProductApi productApi;
    @Autowired
    private RestTemplate restTemplate;
    public OrderInfo SelectOrderById(Integer orderId) {
        OrderInfo orderInfo = orderMapper.selectOrderById(orderId);
//        String url = "http://product-service/product/" + orderInfo.getProductId();
//        ProductInfo productInfo = restTemplate.getForObject(url, ProductInfo.class);
        if(orderInfo == null){
            return null;
        }
        ProductInfo productInfo = productApi.getProductInfoById(orderInfo.getProductId());
        orderInfo.setProductInfo(productInfo);
        return orderInfo;
    }
}
