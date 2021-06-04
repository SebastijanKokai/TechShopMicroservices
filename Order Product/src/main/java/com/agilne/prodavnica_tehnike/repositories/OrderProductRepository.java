package com.agilne.prodavnica_tehnike.repositories;

import com.agilne.prodavnica_tehnike.models.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderProductRepository extends JpaRepository<OrderProduct, Integer> {
}
