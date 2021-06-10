package com.agilne.prodavnica_tehnike.controllers;

import com.agilne.prodavnica_tehnike.dtos.GetOrderItemDto;
import com.agilne.prodavnica_tehnike.dtos.PostOrderItemDto;
import com.agilne.prodavnica_tehnike.models.OrderItem;
import com.agilne.prodavnica_tehnike.services.interfaces.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/items")
public class OrderItemController {

    @Autowired
    private OrderItemService orderItemService;

    @GetMapping()
    public ResponseEntity<List<GetOrderItemDto>> getAllOrderItems(){
        return ResponseEntity.ok(orderItemService.findAllOrderItems());
    }
    @GetMapping(path = "/{productId}/{orderId}")
    public ResponseEntity<GetOrderItemDto> getOrderItemById(@PathVariable("productId") Integer productId, @PathVariable("orderId") Integer orderId)
    {
        return ResponseEntity.ok(orderItemService.findOrderItemById(productId, orderId));
    }
    @PostMapping()
    public ResponseEntity<OrderItem> insertOrderItem(@RequestBody PostOrderItemDto item)
    {
        return ResponseEntity.ok(orderItemService.insert(item));
    }
    @PutMapping(path = "/{productId}/{orderId}")
    public ResponseEntity<Optional<OrderItem>> updateOrderItem(@RequestBody PostOrderItemDto item, @PathVariable("productId") Integer productId, @PathVariable("orderId") Integer orderId)
    {
        return ResponseEntity.ok(orderItemService.update(item,productId,orderId));
    }
    @DeleteMapping(path = "/{productId}/{orderId}")
    public ResponseEntity<Void> deleteOrderItem(@PathVariable("productId") Integer productId,@PathVariable("orderId") Integer orderId)
    {
        orderItemService.delete(productId, orderId);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
