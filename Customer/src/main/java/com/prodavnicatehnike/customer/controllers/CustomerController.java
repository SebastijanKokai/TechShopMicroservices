package com.prodavnicatehnike.customer.controllers;

import com.prodavnicatehnike.customer.dtos.CreateCustomerDTO;
import com.prodavnicatehnike.customer.dtos.GetCustomerDTO;
import com.prodavnicatehnike.customer.models.Customer;
import com.prodavnicatehnike.customer.repositories.CustomerRepository;
import com.prodavnicatehnike.customer.services.interfaces.CustomerService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping()
    ResponseEntity<List<GetCustomerDTO>> getAllCustomers(){

        return ResponseEntity.ok(customerService.findAllCustomers());
    }

    @GetMapping(path="/{id}")
    ResponseEntity<GetCustomerDTO> getCustomerByID(@PathVariable("id") Integer id){

        if(customerService.findCustomerById(id) != null) {
            return ResponseEntity.ok(customerService.findCustomerById(id));
        }
        else
            return ResponseEntity.badRequest().body(customerService.findCustomerById(id));
    }

    @PostMapping()
    public ResponseEntity<GetCustomerDTO> insertCustomer(@RequestBody CreateCustomerDTO customer){
        return ResponseEntity.ok(customerService.createCustomer(customer));
    }

    @PutMapping(path="/{id}")
    public ResponseEntity<GetCustomerDTO> updateCustomer(@RequestBody CreateCustomerDTO newCustomer, @PathVariable Integer id){
        if(customerService.updateCustomer(newCustomer,id) != null) {
            return ResponseEntity.ok(customerService.updateCustomer(newCustomer,id));
        }
        else
            return ResponseEntity.badRequest().body(customerService.updateCustomer(newCustomer,id));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable("id") Integer id){
        customerService.deleteCustomer(id);
        return  ResponseEntity.noContent().build();
    }

}
