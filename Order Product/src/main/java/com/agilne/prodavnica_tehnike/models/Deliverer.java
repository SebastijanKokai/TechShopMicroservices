package com.agilne.prodavnica_tehnike.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.util.List;

@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Deliverer {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    private String companyName;

    private String contact;

    private String address;

    // Relationships
    @OneToMany(mappedBy = "deliverer")
    private List<OrderProduct> orders;

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public String getCompanyName() { return companyName; }

    public void setCompanyName(String companyName) { this.companyName = companyName; }

    public String getContact() { return contact; }

    public void setContact(String contact) { this.contact = contact; }

    public String getAddress() { return address; }

    public void setAddress(String address) { this.address = address; }
}
