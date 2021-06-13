package com.prodavnicatehnike.customer.dtos;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)

public class CreateCustomerDTO {
    public String name;
    public String lastName;
    public String contact;
    public String address;

    public CreateCustomerDTO( String name, String lastName, String contact, String address) {
        this.name = name;
        this.lastName = lastName;
        this.contact = contact;
        this.address = address;
    }
}
