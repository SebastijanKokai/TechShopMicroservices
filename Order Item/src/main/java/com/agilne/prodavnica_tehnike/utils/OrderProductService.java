package com.agilne.prodavnica_tehnike.utils;

import com.agilne.prodavnica_tehnike.models.OrderProduct;
import org.springframework.web.client.RestTemplate;

public class OrderProductService {

    RestTemplate restTemplate = new RestTemplate();
    private final String orderProductURL = "http://localhost:8085/orders";

    public OrderProduct getOrderById(Integer orderId) {
        return restTemplate.getForObject(orderProductURL + "/" + orderId, OrderProduct.class);
    }
}
