package com.prodavnicatehnike.customer.services.implementations;

import com.prodavnicatehnike.customer.dtos.CreateCustomerDTO;
import com.prodavnicatehnike.customer.dtos.GetCustomerDTO;
import com.prodavnicatehnike.customer.models.Customer;
import com.prodavnicatehnike.customer.repositories.CustomerRepository;
import com.prodavnicatehnike.customer.services.interfaces.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<GetCustomerDTO> findAllCustomers() {
        List<Customer> allCustomers=customerRepository.findAll();
        List<GetCustomerDTO> mappedCustomers = new ArrayList<>() ;
        for (Customer s : allCustomers) {
            mappedCustomers.add(new GetCustomerDTO(s.getId(),s.getName(),s.getLastName(),s.getContact(),s.getAddress()));
        }
        return mappedCustomers;
    }

    @Override
    public GetCustomerDTO findCustomerById(Integer id) {

        if(customerRepository.findById(id).isPresent()) {
            Customer deliverer = customerRepository.findById(id).get();
            String name = deliverer.getName();
            String lastname = deliverer.getAddress();
            String  contact = deliverer.getContact();
            String address = deliverer.getAddress();
            return new GetCustomerDTO(id, name, lastname, contact, address);
        }
        return null;
    }

    @Override
    public GetCustomerDTO createCustomer(CreateCustomerDTO customer) {

        Customer newCustomer = new Customer();
        newCustomer.setName(customer.name);
        newCustomer.setLastName(customer.lastName);
        newCustomer.setContact(customer.contact);
        newCustomer.setAddress(customer.address);
        newCustomer = customerRepository.save(newCustomer);

        GetCustomerDTO mappedProduct=new GetCustomerDTO(newCustomer.getId(),newCustomer.getName(),newCustomer.getLastName(),newCustomer.getContact(),newCustomer.getAddress());

        return mappedProduct;
    }

    @Override
    public GetCustomerDTO updateCustomer(CreateCustomerDTO newCustomer, Integer id) {
        if(customerRepository.findById(id).isPresent()) {
            Customer updatedCustomer = customerRepository.findById(id).map(oldCustomer -> {
                oldCustomer.setName(newCustomer.name);
                oldCustomer.setLastName(newCustomer.lastName);
                oldCustomer.setContact(newCustomer.contact);
                oldCustomer.setAddress(newCustomer.address);
                return customerRepository.save(oldCustomer);
            }).get();

            GetCustomerDTO mappedCustomer = new GetCustomerDTO(updatedCustomer.getId(), updatedCustomer.getName(), updatedCustomer.getLastName(), updatedCustomer.getContact(), updatedCustomer.getAddress());
            return mappedCustomer;
        }
        else
            return null;
    }

    @Override
    public void deleteCustomer(Integer id) {
        if(customerRepository.findById(id).isPresent()) {
            customerRepository.deleteById(id);
        }
    }
}
