package com.agilne.prodavnica_tehnike.repositories;
import com.agilne.prodavnica_tehnike.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ProductRepository extends JpaRepository<Product,Integer> {

}
