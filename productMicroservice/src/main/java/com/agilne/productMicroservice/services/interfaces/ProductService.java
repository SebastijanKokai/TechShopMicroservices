package com.agilne.productMicroservice.services.interfaces;

import com.agilne.productMicroservice.models.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    public List<Product> getAllProducts();
    public Optional<Product> getProductById(Integer id);
    public Product insert(Product product);
    public Optional<Product> update(Product product, Integer id);
    public void delete(Integer id);
}
