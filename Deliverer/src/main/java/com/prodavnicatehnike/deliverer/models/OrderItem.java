package com.prodavnicatehnike.deliverer.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@IdClass(OrderItemId.class)
public class OrderItem {

    // Composite primary key
    @Id
    private Integer productId;
    @Id
    private Integer orderId;

    // Attributes
    private Integer quantity;

    // Relationships
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "orderId", insertable = false,updatable = false)
    private OrderProduct orderProduct;

    @ManyToOne
    @JoinColumn(name = "productId",insertable = false,updatable = false)
    private Product product;

    // Getters and setters
    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public OrderProduct getOrderProduct() {
        return orderProduct;
    }

    public void setOrderProduct(OrderProduct orderProduct) {
        this.orderProduct = orderProduct;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

}
