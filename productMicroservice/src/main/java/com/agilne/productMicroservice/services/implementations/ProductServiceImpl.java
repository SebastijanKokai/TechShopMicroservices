package com.agilne.productMicroservice.services.implementations;

import com.agilne.productMicroservice.Dto.ProductCreationDto;
import com.agilne.productMicroservice.Dto.ProductDto;
import com.agilne.productMicroservice.Dto.ProductTypeDto;
import com.agilne.productMicroservice.Dto.ProductUpdateDto;
import com.agilne.productMicroservice.models.Product;
import com.agilne.productMicroservice.models.ProductType;
import com.agilne.productMicroservice.repositories.ProductRepository;
import com.agilne.productMicroservice.services.interfaces.ProductService;
import com.agilne.productMicroservice.services.interfaces.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductTypeService productTypeService;
    public ProductRepository getProductRepository() {
        return productRepository;
    }

    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductDto> getAllProducts() {

        List<Product> allProducts=productRepository.findAll();
        List<ProductDto> mappedProducts=new ArrayList<>() ;
        for (Product s :
                allProducts) {
            s.setProductType(productTypeService.GetProductTypeById(s.getProductTypeId()));
           mappedProducts.add(new ProductDto(s.getId(),s.getName(),s.getProductTypeId(),s.getProductType().getName(),s.getAvailable()));
        }
        return mappedProducts;
    }

    @Override
    public ProductDto getProductById(Integer id) {
        if (productRepository.findById(id).isPresent()) {
            Product foundProduct = productRepository.findById(id).get();
            foundProduct.setProductType(productTypeService.GetProductTypeById(foundProduct.getProductTypeId()));
            ProductDto mappedProduct = new ProductDto(foundProduct.getId(), foundProduct.getName(), foundProduct.getProductTypeId(), foundProduct.getProductType().getName(), foundProduct.getAvailable());
            return mappedProduct;
        }
        return null;
    }

    @Override
    public ProductDto insert(ProductCreationDto product) {

        Product newProduct=new Product();
        newProduct.setProductTypeId(product.typeId);
        newProduct.setAvailable(product.available);
        newProduct.setName(product.name);
        newProduct=productRepository.save(newProduct);
        newProduct.setProductType(productTypeService.GetProductTypeById(product.typeId));
        ProductDto mappedProduct=new ProductDto(newProduct.getId(),newProduct.getName(),newProduct.getProductTypeId(),newProduct.getProductType().getName(),newProduct.getAvailable());
        return mappedProduct;
    }

    @Override
    public ProductDto update(ProductUpdateDto product, Integer id) {
        Product updatedProduct=productRepository.findById(id).map(oldProduct ->{
            oldProduct.setName(product.name);
            oldProduct.setProductTypeId(product.typeId);
            oldProduct.setAvailable(product.available);
            oldProduct.setId(product.id);
            return productRepository.save(oldProduct);
        } ).get();
        updatedProduct.setProductType(productTypeService.GetProductTypeById(updatedProduct.getProductTypeId()));

        ProductDto mappedProduct=new ProductDto(updatedProduct.getId(),updatedProduct.getName(),updatedProduct.getProductTypeId(),updatedProduct.getProductType().getName(),updatedProduct.getAvailable());
        return mappedProduct;
    }

    @Override
    public void delete(Integer id) {
        productRepository.deleteById(id);
    }
}
