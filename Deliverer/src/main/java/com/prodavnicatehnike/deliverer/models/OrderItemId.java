package com.prodavnicatehnike.deliverer.models;

import java.io.Serializable;
import java.util.Objects;

public class OrderItemId implements Serializable {

    private Integer productId;
    private Integer orderId;

    // Iz nekog razloga nece da uradi get metodu bez ovog default-nog konstruktora
    public OrderItemId() {

    }

    public OrderItemId(Integer productId, Integer orderId) {
        this.productId = productId;
        this.orderId = orderId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItemId that = (OrderItemId) o;
        return orderId.equals(that.orderId) && productId.equals(that.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, productId);
    }
}
