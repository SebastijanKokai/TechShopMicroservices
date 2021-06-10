package com.agilne.prodavnica_tehnike.repositories;

import com.agilne.prodavnica_tehnike.models.OrderItem;
import com.agilne.prodavnica_tehnike.models.OrderItemId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemId> {
}
