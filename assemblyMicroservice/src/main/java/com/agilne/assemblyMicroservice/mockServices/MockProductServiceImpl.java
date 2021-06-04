package com.agilne.assemblyMicroservice.mockServices;

import com.agilne.assemblyMicroservice.models.Product;
import com.agilne.assemblyMicroservice.models.ProductType;
import com.agilne.assemblyMicroservice.services.interfaces.ProductService;
import org.springframework.stereotype.Service;

//@Service
public class MockProductServiceImpl implements ProductService {
    @Override
    public Product GetProductById(Integer id) {
        Product newProduct=new Product();
        ProductType newType=new ProductType();
        newType.setId(2);
        newType.setName("Nesto");
        newProduct.setProductType(newType);
        newProduct.setId(id);
        newProduct.setAvailable(200);
        newProduct.setName("Ja sam fake product");
        return newProduct;
    }
}
