package com.prodavnicatehnike.customer.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.util.List;

@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Customer {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String lastName;

    private String contact;

    private String address;

    // Relationships
    @OneToMany(mappedBy = "customer")
    private List<OrderProduct> orders;


    public Customer() {

    }

    public Customer(Integer id, String name, String lastName, String contact, String address) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.contact = contact;
        this.address = address;
    }



    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getLastName() { return lastName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getContact() { return contact; }

    public void setContact(String contact) { this.contact = contact; }

    public String getAddress() { return address; }

    public void setAddress(String address) { this.address = address; }
}
