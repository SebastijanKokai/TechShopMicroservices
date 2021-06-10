package com.agilne.prodavnica_tehnike.dtos;

import com.agilne.prodavnica_tehnike.models.Customer;
import com.agilne.prodavnica_tehnike.models.Deliverer;
import com.agilne.prodavnica_tehnike.models.Employee;
import com.agilne.prodavnica_tehnike.models.OrderItem;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.criterion.Order;

import java.util.Date;
import java.util.List;

public class GetOrderDto {

    public GetOrderDto(Integer id, Date orderDate, Double price, List<OrderItem> orderItems, String employee, String deliverer, String customer) {
        this.id = id;
        this.orderDate = orderDate;
        this.price = price;
        this.orderItems = orderItems;
        this.employee = employee;
        this.deliverer = deliverer;
        this.customer = customer;
    }

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("orderDate")
    private Date orderDate;

    @JsonProperty("price")
    private Double price;

    @JsonProperty("orderItems")
    private List<OrderItem> orderItems;

    @JsonProperty
    private String employee;

    @JsonProperty
    private String deliverer;

    @JsonProperty
    private String customer;

    // Getters and setters
    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public String getDeliverer() {
        return deliverer;
    }

    public void setDeliverer(String deliverer) {
        this.deliverer = deliverer;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }
}
