package com.agilne.productMicroservice.services.implementations;

import com.agilne.productMicroservice.models.Product;
import com.agilne.productMicroservice.repositories.ProductRepository;
import com.agilne.productMicroservice.services.interfaces.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    public ProductRepository getProductRepository() {
        return productRepository;
    }

    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> getProductById(Integer id) {
        return productRepository.findById(id);
    }

    @Override
    public Product insert(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Optional<Product> update(Product product, Integer id) {
        return productRepository.findById(id).map(oldProduct ->{
            oldProduct.setAvailable(product.getAvailable());
            oldProduct.setProductType(product.getProductType());
            oldProduct.setName(product.getName());
            return productRepository.save(oldProduct);
        } );
    }

    @Override
    public void delete(Integer id) {
        productRepository.deleteById(id);
    }
}
