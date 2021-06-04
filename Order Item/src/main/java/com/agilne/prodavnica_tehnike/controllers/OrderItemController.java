package com.agilne.prodavnica_tehnike.controllers;

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
    public ResponseEntity<List<OrderItem>> getAllOrderItems(){
        return ResponseEntity.ok(orderItemService.findAllOrderItems());
    }
    @GetMapping(path = "/{productId}/{orderId}")
    public ResponseEntity<Optional<OrderItem>> getAssemblyById(@PathVariable("productId") Integer productId, @PathVariable("orderId") Integer orderId)
    {
        return ResponseEntity.ok(orderItemService.findOrderItemById(productId, orderId));
    }
    @PostMapping()
    public ResponseEntity<OrderItem> insertAssembly(@RequestBody OrderItem item)
    {
        return ResponseEntity.ok(orderItemService.insert(item));
    }
    @PutMapping(path = "/{productId}/{orderId}")
    public ResponseEntity<Optional<OrderItem>> updateAssembly(@RequestBody OrderItem item, @PathVariable("productId") Integer productId, @PathVariable("orderId") Integer orderId)
    {
        return ResponseEntity.ok(orderItemService.update(item,productId,orderId));
    }
    @DeleteMapping(path = "/{productId}/{orderId}")
    public ResponseEntity<Void> deleteAssembly(@PathVariable("productId") Integer productId,@PathVariable("orderId") Integer orderId)
    {
        orderItemService.delete(productId, orderId);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
