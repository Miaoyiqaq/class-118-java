package org.example.order.service;

import lombok.extern.slf4j.Slf4j;
import org.example.order.mapper.OrderMapper;
import org.example.order.model.OrderInfo;
import org.example.order.model.ProductInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Slf4j
@Service
public class OrderService {

    private static final String PRODUCT_SERVICE = "product-service";

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private DiscoveryClient discoveryClient;

    public OrderInfo SelectOrderById(Integer orderId) {
        OrderInfo orderInfo = orderMapper.selectOrderById(orderId);
        if (orderInfo == null) {
            return null;
        }
        // 每次请求都从本地注册表读取，不能在 @PostConstruct 里把实例列表缓存成字段
        List<ServiceInstance> instances = discoveryClient.getInstances(PRODUCT_SERVICE);
        if (instances.isEmpty()) {
            log.warn("未从 Eureka 获取到 {} 实例（本地注册表为空，等待下一次拉取）", PRODUCT_SERVICE);
            return orderInfo;
        }
        log.info("{} 可用实例数: {} -> {}", PRODUCT_SERVICE, instances.size(),
                instances.stream().map(i -> i.getUri().toString()).toList());

        // 交给 @LoadBalanced RestTemplate 按服务名做负载均衡，路径不要再拼出双斜杠
        String url = "http://" + PRODUCT_SERVICE + "/product/" + orderInfo.getProductId();
        log.info("远程调用url: {}", url);
        ProductInfo productInfo = restTemplate.getForObject(url, ProductInfo.class);
        orderInfo.setProductInfo(productInfo);
        return orderInfo;
    }
}
