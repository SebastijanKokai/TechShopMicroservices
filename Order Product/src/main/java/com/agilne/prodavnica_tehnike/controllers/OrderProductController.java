package com.agilne.prodavnica_tehnike.controllers;

import com.agilne.prodavnica_tehnike.models.OrderProduct;
import com.agilne.prodavnica_tehnike.services.interfaces.OrderProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/orders")
public class OrderProductController {

    @Autowired
    private OrderProductService orderProductService;

    @GetMapping()
    public ResponseEntity<List<OrderProduct>> getAllOrders()
    {
        return ResponseEntity.ok(orderProductService.findAllOrders());
    }
    @GetMapping(path="{id}")
    public ResponseEntity<Optional<OrderProduct>> getOrderById(@PathVariable("id") Integer id)
    {
        return  ResponseEntity.ok(orderProductService.findOrderById(id));
    }
    @PostMapping()
    public ResponseEntity<OrderProduct> insertOrder(@RequestBody OrderProduct order)
    {
        return ResponseEntity.ok(orderProductService.insert(order));
    }
    @PutMapping(path = "/{id}")
    public ResponseEntity<Optional<OrderProduct>> updateOrder(@RequestBody OrderProduct order, @PathVariable("id") Integer id)
    {
        return ResponseEntity.ok(orderProductService.update(order,id));
    }
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable("id") Integer id)
    {
        orderProductService.delete(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
