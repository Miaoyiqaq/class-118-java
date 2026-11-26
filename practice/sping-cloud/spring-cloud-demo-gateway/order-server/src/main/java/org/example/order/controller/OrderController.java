package org.example.order.controller;

import org.example.order.model.OrderInfo;
import org.example.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @GetMapping("/{orderId}")
    public OrderInfo getOrderById(@PathVariable("orderId") Integer orderId) {
        return orderService.SelectOrderById(orderId);

    }
}
