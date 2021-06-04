package com.agilne.prodavnica_tehnike.services.implementations;

import com.agilne.prodavnica_tehnike.models.OrderItem;
import com.agilne.prodavnica_tehnike.models.OrderItemId;
import com.agilne.prodavnica_tehnike.repositories.OrderItemRepository;
import com.agilne.prodavnica_tehnike.services.interfaces.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderItemImpl implements OrderItemService {

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public List<OrderItem> findAllOrderItems() {
        return orderItemRepository.findAll();
    }

    @Override
    public Optional<OrderItem> findOrderItemById(Integer productId, Integer orderId) {
        return orderItemRepository.findById(new OrderItemId(productId, orderId));
    }

    @Override
    public OrderItem insert(OrderItem item) {
        return orderItemRepository.save(item);
    }

    @Override
    public Optional<OrderItem> update(OrderItem item, Integer productId, Integer orderId) {
        return orderItemRepository.findById(new OrderItemId(productId, orderId)).map(oldItem ->{
            oldItem.setQuantity(item.getQuantity());
            return orderItemRepository.save(oldItem);
        } );
    }

    @Override
    public void delete(Integer productId, Integer orderId) {
        orderItemRepository.deleteById(new OrderItemId(productId, orderId));
    }
}
