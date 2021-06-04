package com.agilne.prodavnica_tehnike.services.implementations;

import com.agilne.prodavnica_tehnike.models.OrderProduct;
import com.agilne.prodavnica_tehnike.repositories.OrderProductRepository;
import com.agilne.prodavnica_tehnike.services.interfaces.OrderProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderProductImpl implements OrderProductService {

    @Autowired
    private OrderProductRepository orderRepository;

    @Override
    public List<OrderProduct> findAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Optional<OrderProduct> findOrderById(Integer id) {
        return orderRepository.findById(id);
    }

    @Override
    public OrderProduct insert(OrderProduct order) {
        return orderRepository.save(order);
    }

    @Override
    public Optional<OrderProduct> update(OrderProduct order, Integer id) {
        return orderRepository.findById(id).map(oldOrder ->{
            oldOrder.setOrderDate(order.getOrderDate());
            // oldOrder.setOrderItems(order.getOrderItems());
            oldOrder.setPrice(order.getPrice());
            return orderRepository.save(oldOrder);
        } );
    }

    @Override
    public void delete(Integer id) {
        orderRepository.deleteById(id);
    }
}

/*
@TODO
Kad izbrisem order, da se izbrisu i itemi unutar tog order-a
 */