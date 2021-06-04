package com.agilne.prodavnica_tehnike.services.interfaces;

import com.agilne.prodavnica_tehnike.models.OrderProduct;

import java.util.List;
import java.util.Optional;

public interface OrderProductService {
    public List<OrderProduct> findAllOrders();
    public Optional<OrderProduct> findOrderById(Integer id);
    public OrderProduct insert(OrderProduct order);
    public Optional<OrderProduct> update(OrderProduct order, Integer id);
    public void delete(Integer id);
}
