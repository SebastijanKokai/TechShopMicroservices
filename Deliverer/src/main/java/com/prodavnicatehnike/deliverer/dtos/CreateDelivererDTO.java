package com.prodavnicatehnike.deliverer.dtos;

public class CreateDelivererDTO {
    public String companyName;
    public String contact;
    public String address;

    public CreateDelivererDTO( String companyName, String contact,String address) {
        this.companyName = companyName;
        this.contact = contact;
        this.address = address;
    }
}
