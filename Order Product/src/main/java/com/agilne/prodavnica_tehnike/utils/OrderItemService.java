package com.agilne.prodavnica_tehnike.utils;

import com.agilne.prodavnica_tehnike.dtos.PostOrderItemDto;
import com.agilne.prodavnica_tehnike.models.OrderItem;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class OrderItemService {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String orderItemURL = "http://localhost:8084/items";

    public void postOrderItem(OrderItem orderItem) {
        restTemplate.postForObject(orderItemURL, orderItem, PostOrderItemDto.class);
    }

    public ResponseEntity<OrderItem[]> getOrderItems() {
        return restTemplate.getForEntity(orderItemURL, OrderItem[].class);
    }
}
