package com.agilne.prodavnica_tehnike.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
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

    @Column(name = "customerId")
    private Integer customerId;

    @Column(name = "delivererId")
    private Integer delivererId;

    @Column(name = "employeeId")
    private Integer employeeId;

    // Relationships
    // @OneToMany(targetEntity = OrderItem.class)
    @OneToMany(mappedBy="orderId")
    private List<OrderItem> orderItems = new ArrayList<OrderItem>();

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

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Deliverer getDeliverer() {
        return deliverer;
    }

    public void setDeliverer(Deliverer deliverer) {
        this.deliverer = deliverer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getDelivererId() {
        return delivererId;
    }

    public void setDelivererId(Integer delivererId) {
        this.delivererId = delivererId;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    // Methods
    public void addOrderItem(OrderItem orderItem) {
        orderItems.add(orderItem);
    }


}
