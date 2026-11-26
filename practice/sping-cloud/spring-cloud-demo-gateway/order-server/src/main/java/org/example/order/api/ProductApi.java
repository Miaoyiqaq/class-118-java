package org.example.order.api;


import org.example.product.api.ProductInterface;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "product-service", path = "/product")
public interface ProductApi extends ProductInterface {
}


