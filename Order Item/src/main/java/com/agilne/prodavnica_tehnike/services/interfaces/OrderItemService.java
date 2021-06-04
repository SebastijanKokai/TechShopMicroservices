package com.agilne.prodavnica_tehnike.services.interfaces;

import com.agilne.prodavnica_tehnike.models.OrderItem;
import com.agilne.prodavnica_tehnike.models.OrderItemId;
import com.agilne.prodavnica_tehnike.models.OrderProduct;

import java.util.List;
import java.util.Optional;

public interface OrderItemService {
    public List<OrderItem> findAllOrderItems();
    public Optional<OrderItem> findOrderItemById(Integer productId, Integer orderId);
    public OrderItem insert(OrderItem item);
    public Optional<OrderItem> update(OrderItem item, Integer productId, Integer orderId);
    public void delete(Integer productId, Integer orderId);
}
