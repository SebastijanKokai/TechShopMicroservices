package com.prodavnicatehnike.deliverer.controllers;

import com.prodavnicatehnike.deliverer.dtos.CreateDelivererDTO;
import com.prodavnicatehnike.deliverer.dtos.GetDelivererDTO;
import com.prodavnicatehnike.deliverer.models.Deliverer;
import com.prodavnicatehnike.deliverer.repositories.DelivererRepository;
import com.prodavnicatehnike.deliverer.services.interfaces.DelivererService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/deliverers")
public class DelivererController {

    @Autowired
    private DelivererService delivererService;

    @GetMapping()
    ResponseEntity<List<GetDelivererDTO>> getAllDeliverers(){
        return ResponseEntity.ok(delivererService.findAllDeliverers());
    }

    @GetMapping(path="/{id}")
    ResponseEntity<GetDelivererDTO> getDelivererByID(@PathVariable("id") Integer id){
        if(delivererService.findDelivererById(id) != null) {
            return ResponseEntity.ok(delivererService.findDelivererById(id));
        }
        else
            return ResponseEntity.badRequest().body(delivererService.findDelivererById(id));
    }

    @PostMapping()
    public ResponseEntity<GetDelivererDTO> insertDeliverer(@RequestBody CreateDelivererDTO deliverer){
        return ResponseEntity.ok(delivererService.createDeliverer(deliverer));
    }

    @PutMapping(path="/{id}")
    public ResponseEntity<GetDelivererDTO> updateCustomer(@RequestBody CreateDelivererDTO newDeliverer, @PathVariable Integer id){
       if(delivererService.updateDeliverer(newDeliverer,id) != null) {
           return ResponseEntity.ok(delivererService.updateDeliverer(newDeliverer, id));
       }
       else
           return ResponseEntity.badRequest().body(delivererService.updateDeliverer(newDeliverer,id));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable("id") Integer id){
        delivererService.deleteDeliverer(id);
        return  ResponseEntity.noContent().build();
    }
}
