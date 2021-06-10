package com.agilne.prodavnica_tehnike.dtos;

import com.agilne.prodavnica_tehnike.models.OrderProduct;
import com.agilne.prodavnica_tehnike.models.Product;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class PostOrderItemDto {

    public PostOrderItemDto(Integer productId, Integer orderId, Integer quantity) {
        this.productId = productId;
        this.orderId = orderId;
        this.quantity = quantity;
    }

    @JsonProperty
    private Integer productId;
    @JsonProperty
    private Integer orderId;
    @JsonProperty
    private Integer quantity;

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
}
