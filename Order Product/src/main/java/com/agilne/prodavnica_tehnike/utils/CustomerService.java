package com.agilne.prodavnica_tehnike.utils;

import com.agilne.prodavnica_tehnike.models.Customer;
import org.springframework.web.client.RestTemplate;

public class CustomerService {
    private final RestTemplate restTemplate = new RestTemplate();
    private final String customerURL = "http://localhost:8081/customers";

    public Customer getCustomerById(Integer customerId) {
        return restTemplate.getForObject(customerURL + "/" + customerId, Customer.class);
    }
}
