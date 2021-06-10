package com.agilne.prodavnica_tehnike.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PostOrderItemDto {

    public PostOrderItemDto() {

    }

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
