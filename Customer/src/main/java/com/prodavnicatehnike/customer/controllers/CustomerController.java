package com.prodavnicatehnike.customer.controllers;

import com.prodavnicatehnike.customer.models.Customer;
import com.prodavnicatehnike.customer.repositories.CustomerRepository;
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
    private CustomerRepository customerRepository;

    @GetMapping()
    ResponseEntity<List<Customer>> getAllCustomers(){
        return ResponseEntity.ok(customerRepository.findAll());
    }

    @GetMapping(path="/{id}")
    ResponseEntity<Optional<Customer>> getCustomerByID(@PathVariable("id") Integer id){
        return ResponseEntity.ok(customerRepository.findById(id));
    }

    @PostMapping()
    public ResponseEntity<Customer> insertCustomer(@RequestBody Customer customer){
        return ResponseEntity.ok(customerRepository.save(customer));
    }

    @PutMapping(path="/{id}")
    public ResponseEntity<Optional<Customer>> updateCustomer(@RequestBody Customer newCustomer, @PathVariable Integer id){
        Optional<Customer> customer = customerRepository.findById(id).map(oldCustomer -> {
            oldCustomer.setName(newCustomer.getName());
            oldCustomer.setLastName(newCustomer.getLastName());
            oldCustomer.setAddress(newCustomer.getAddress());
            oldCustomer.setContact(newCustomer.getContact());
            return customerRepository.save(oldCustomer);
        });
        if(customer.isPresent()){
            return ResponseEntity.ok(customer);
        }
        else {
            return ResponseEntity.badRequest().body(customer);
        }

    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable("id") Integer id){
        customerRepository.deleteById(id);
        return  ResponseEntity.noContent().build();
    }

}
