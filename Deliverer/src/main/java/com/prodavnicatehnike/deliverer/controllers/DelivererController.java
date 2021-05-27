package com.prodavnicatehnike.deliverer.controllers;

import com.prodavnicatehnike.deliverer.models.Deliverer;
import com.prodavnicatehnike.deliverer.repositories.DelivererRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/deliverers")
public class DelivererController {

    @Autowired
    private DelivererRepository delivererRepository;

    @GetMapping()
    ResponseEntity<List<Deliverer>> getAllDeliverers(){

        return ResponseEntity.ok(delivererRepository.findAll());
    }

    @GetMapping(path="/{id}")
    ResponseEntity<Optional<Deliverer>> getDelivererByID(@PathVariable("id") Integer id){
        return ResponseEntity.ok(delivererRepository.findById(id));
    }

    @PostMapping()
    public ResponseEntity<Deliverer> insertDeliverer(@RequestBody Deliverer deliverer){
        return ResponseEntity.ok(delivererRepository.save(deliverer));
    }

    @PutMapping(path="/{id}")
    public ResponseEntity<Optional<Deliverer>> updateCustomer(@RequestBody Deliverer newDeliverer, @PathVariable Integer id){
        Optional<Deliverer> deliverer = delivererRepository.findById(id).map(oldDeliverer -> {
            oldDeliverer.setCompanyName(newDeliverer.getCompanyName());
            oldDeliverer.setAddress(newDeliverer.getAddress());
            oldDeliverer.setContact(newDeliverer.getContact());
            return delivererRepository.save(oldDeliverer);
        });
        if(deliverer.isPresent()){
            return ResponseEntity.ok(deliverer);
        }
        else {
            return ResponseEntity.badRequest().body(deliverer);
        }

    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable("id") Integer id){
        delivererRepository.deleteById(id);
        return  ResponseEntity.noContent().build();
    }
}
