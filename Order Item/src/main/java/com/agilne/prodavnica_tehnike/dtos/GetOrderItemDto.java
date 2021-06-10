package com.agilne.prodavnica_tehnike.dtos;

import com.agilne.prodavnica_tehnike.models.OrderProduct;
import com.agilne.prodavnica_tehnike.models.Product;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

public class GetOrderItemDto {

    public GetOrderItemDto(Integer productId, Integer orderId, String productName, Integer quantity, Date dateOrdered) {
        this.productId = productId;
        this.orderId = orderId;
        this.productName = productName;
        this.quantity = quantity;
        this.dateOrdered = dateOrdered;
    }
    @JsonProperty
    private Integer productId;

    @JsonProperty
    private Integer orderId;

    @JsonProperty
    private Integer quantity;

    @JsonProperty
    private Date dateOrdered;

    @JsonProperty
    private String productName;
}
