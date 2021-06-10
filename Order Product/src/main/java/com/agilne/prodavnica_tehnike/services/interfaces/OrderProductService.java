package com.agilne.prodavnica_tehnike.services.interfaces;

import com.agilne.prodavnica_tehnike.dtos.GetOrderDto;
import com.agilne.prodavnica_tehnike.dtos.ModifyOrderDto;
import com.agilne.prodavnica_tehnike.dtos.PostOrderDto;
import com.agilne.prodavnica_tehnike.models.OrderProduct;

import java.util.List;
import java.util.Optional;

public interface OrderProductService {
    public List<GetOrderDto> findAllOrders();
    public GetOrderDto findOrderById(Integer id);
    public OrderProduct insert(PostOrderDto order);
    public Optional<OrderProduct> update(ModifyOrderDto order, Integer id);
    public void delete(Integer id);
}
