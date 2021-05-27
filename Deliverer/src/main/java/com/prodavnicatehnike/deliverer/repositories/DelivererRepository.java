package com.prodavnicatehnike.deliverer.repositories;

import com.prodavnicatehnike.deliverer.models.Deliverer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DelivererRepository extends JpaRepository<Deliverer, Integer> {
}
