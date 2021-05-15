package com.agilne.productMicroservice.repositories;
import com.agilne.productMicroservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ProductRepository extends JpaRepository<Product,Integer> {

}
