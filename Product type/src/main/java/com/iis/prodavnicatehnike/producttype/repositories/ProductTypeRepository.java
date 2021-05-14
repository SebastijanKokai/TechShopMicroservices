package com.iis.prodavnicatehnike.producttype.repositories;

import com.iis.prodavnicatehnike.producttype.models.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductTypeRepository extends JpaRepository<ProductType,Integer> {
}
