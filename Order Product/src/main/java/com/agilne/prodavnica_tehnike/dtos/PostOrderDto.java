package com.agilne.prodavnica_tehnike.dtos;

import com.agilne.prodavnica_tehnike.models.Customer;
import com.agilne.prodavnica_tehnike.models.Deliverer;
import com.agilne.prodavnica_tehnike.models.Employee;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;

import java.util.Date;
import java.util.List;

public class PostOrderDto {

    @NotNull
    @JsonProperty("orderDate")
    private Date orderDate;

    @NotNull
    @JsonProperty("price")
    private Double price;

    @NotNull
    @JsonProperty("orderItems")
    private List<PostOrderItemDto> orderItems;
    @JsonProperty("employee")
    private Integer employeeId;
    @JsonProperty("deliverer")
    private Integer delivererId;
    @JsonProperty("customer")
    private Integer customerId;

    // Getters and setters
    public List<PostOrderItemDto> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<PostOrderItemDto> orderItems) {
        this.orderItems = orderItems;
    }

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

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Integer getDelivererId() {
        return delivererId;
    }

    public void setDelivererId(Integer delivererId) {
        this.delivererId = delivererId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }
}
