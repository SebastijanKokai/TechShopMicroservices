package com.prodavnicatehnike.customer.dtos;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class GetCustomerDTO {
    private Integer id;
    private String name;
    private String lastName;
    private String contact;
    private String address;

    public GetCustomerDTO(Integer id, String name, String lastName, String contact, String address) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.contact = contact;
        this.address = address;
    }
}
