package com.agilne.prodavnica_tehnike.services.implementations;

import com.agilne.prodavnica_tehnike.dtos.GetOrderItemDto;
import com.agilne.prodavnica_tehnike.dtos.PostOrderItemDto;
import com.agilne.prodavnica_tehnike.models.OrderItem;
import com.agilne.prodavnica_tehnike.models.OrderItemId;
import com.agilne.prodavnica_tehnike.models.OrderProduct;
import com.agilne.prodavnica_tehnike.models.Product;
import com.agilne.prodavnica_tehnike.repositories.OrderItemRepository;
import com.agilne.prodavnica_tehnike.services.interfaces.OrderItemService;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class OrderItemImpl implements OrderItemService {

    @Autowired
    private OrderItemRepository orderItemRepository;

    RestTemplate restTemplate = new RestTemplate();
    private final String productResourceURL = "http://localhost:8087/products";
    private final String orderProductURL = "http://localhost:8085/orders";


    @Override
    public List<GetOrderItemDto> findAllOrderItems() {
        List<OrderItem> orderItems = orderItemRepository.findAll();
        List<GetOrderItemDto> mappedOrderItems = new ArrayList<>();

        for(OrderItem orderItem : orderItems) {
            Integer productId = orderItem.getProductId();
            Integer orderId = orderItem.getOrderId();
            String productName = orderItem.getProduct().getName();
            Integer quantity = orderItem.getQuantity();
            Date orderDate = orderItem.getOrderProduct().getOrderDate();
            mappedOrderItems.add(new GetOrderItemDto(productId, orderId, productName, quantity, orderDate));
        }
        return mappedOrderItems;
    }

    @Override
    public GetOrderItemDto findOrderItemById(Integer productId, Integer orderId) {

        if(orderItemRepository.findById(new OrderItemId(productId, orderId)).isPresent()) {
            OrderItem orderItem = orderItemRepository.findById(new OrderItemId(productId, orderId)).get();
            String productName = orderItem.getProduct().getName();
            Integer quantity = orderItem.getQuantity();
            Date orderDate = orderItem.getOrderProduct().getOrderDate();
            return new GetOrderItemDto(productId, orderId, productName, quantity, orderDate);
        }
        return null;
    }

    @Override
    public OrderItem insert(PostOrderItemDto item) {
        OrderProduct orderProduct
                = restTemplate.getForObject(orderProductURL + "/" + item.getOrderId(), OrderProduct.class);
        if(orderProduct != null) {
            Product product
                    = restTemplate.getForObject(productResourceURL + "/" + item.getProductId(), Product.class);
            if(product != null) {

                OrderItem orderItem = new OrderItem();
                orderItem.setProductId(item.getProductId());
                orderItem.setOrderId(item.getOrderId());
                orderItem.setQuantity(item.getQuantity());
                orderItem.setProduct(product);
                orderItem.setOrderProduct(orderProduct);
                return orderItemRepository.save(orderItem);
            }
        }
        return null;
    }

    @Override
    public Optional<OrderItem> update(PostOrderItemDto item, Integer productId, Integer orderId) {
        if(orderItemRepository.findById(new OrderItemId(productId, orderId)).isPresent()) {
            return orderItemRepository.findById(new OrderItemId(productId, orderId)).map(oldItem -> {
                oldItem.setQuantity(item.getQuantity());
                return orderItemRepository.save(oldItem);
            });
        }
        return Optional.empty();
    }

    @Override
    public void delete(Integer productId, Integer orderId) {
        if(orderItemRepository.findById(new OrderItemId(productId, orderId)).isPresent()) {
            orderItemRepository.deleteById(new OrderItemId(productId, orderId));
        }
    }
}
