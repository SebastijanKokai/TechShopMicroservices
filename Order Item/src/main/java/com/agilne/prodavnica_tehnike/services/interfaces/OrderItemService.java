package com.agilne.prodavnica_tehnike.services.interfaces;

import com.agilne.prodavnica_tehnike.dtos.GetOrderItemDto;
import com.agilne.prodavnica_tehnike.dtos.PostOrderItemDto;
import com.agilne.prodavnica_tehnike.models.OrderItem;
import com.agilne.prodavnica_tehnike.models.OrderItemId;
import com.agilne.prodavnica_tehnike.models.OrderProduct;

import java.util.List;
import java.util.Optional;

public interface OrderItemService {
    public List<GetOrderItemDto> findAllOrderItems();
    public GetOrderItemDto findOrderItemById(Integer productId, Integer orderId);
    public OrderItem insert(PostOrderItemDto item);
    public Optional<OrderItem> update(PostOrderItemDto item, Integer productId, Integer orderId);
    public void delete(Integer productId, Integer orderId);
}
