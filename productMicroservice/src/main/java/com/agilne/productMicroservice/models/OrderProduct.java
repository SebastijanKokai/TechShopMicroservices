package com.agilne.productMicroservice.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class OrderProduct {

    // Primary key
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    // Attributes
    private Date orderDate;
    private Double price;

    // Relationships
    // @OneToMany(targetEntity = OrderItem.class)
    @OneToMany(mappedBy="orderId")
    private List<OrderItem> orderItems;

    @ManyToOne
    @JoinColumn(name = "employeeId", insertable = false, updatable = false)
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "delivererId",insertable = false,updatable = false)
    private Deliverer deliverer;

    @ManyToOne
    @JoinColumn(name = "customerId", insertable = false, updatable = false)
    private Customer customer;

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

    // Methods
    public void addOrderItem(OrderItem orderItem) {
        orderItems.add(orderItem);
    }


}
