package com.agilne.productMicroservice.services.interfaces;

import com.agilne.productMicroservice.Dto.ProductCreationDto;
import com.agilne.productMicroservice.Dto.ProductDto;
import com.agilne.productMicroservice.Dto.ProductUpdateDto;
import com.agilne.productMicroservice.models.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    public List<ProductDto> getAllProducts();
    public ProductDto getProductById(Integer id);
    public ProductDto insert(ProductCreationDto product);
    public ProductDto update(ProductUpdateDto product, Integer id);
    public void delete(Integer id);
}
