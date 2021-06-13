package com.prodavnicatehnike.customer.services.interfaces;

import com.prodavnicatehnike.customer.dtos.CreateCustomerDTO;
import com.prodavnicatehnike.customer.dtos.GetCustomerDTO;
import com.prodavnicatehnike.customer.models.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    List<GetCustomerDTO> findAllCustomers();
    GetCustomerDTO findCustomerById(Integer id);
    GetCustomerDTO createCustomer(CreateCustomerDTO customer);
    GetCustomerDTO updateCustomer(CreateCustomerDTO customer, Integer id);
    void deleteCustomer(Integer id);
}