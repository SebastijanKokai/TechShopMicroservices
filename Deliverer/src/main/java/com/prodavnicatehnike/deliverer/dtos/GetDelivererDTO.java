package com.prodavnicatehnike.deliverer.dtos;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class GetDelivererDTO {
    public Integer id;
    public String companyName;
    public String contact;
    public String address;

    public GetDelivererDTO(Integer id, String companyName, String contact, String address) {
        this.id = id;
        this.companyName = companyName;
        this.contact = contact;
        this.address = address;
    }
}
