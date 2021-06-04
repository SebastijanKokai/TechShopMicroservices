package com.agilne.assemblyMicroservice.services.interfaces;

import com.agilne.assemblyMicroservice.models.Product;

public interface ProductService {
    public Product GetProductById(Integer id);
}
