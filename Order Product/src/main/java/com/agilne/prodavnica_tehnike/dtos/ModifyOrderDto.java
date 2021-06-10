package com.agilne.prodavnica_tehnike.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;

import java.util.Date;
import java.util.List;

public class ModifyOrderDto {

    @NotNull
    @JsonProperty("orderDate")
    private Date orderDate;

    @NotNull
    @JsonProperty("price")
    private Double price;

//    @JsonProperty("employee")
//    private Employee employee;
//
//    @JsonProperty("deliverer")
//    private Deliverer deliverer;
//
//    @JsonProperty("customer")
//    private Customer customer;

    // Getters and setters

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
