package com.iis.prodavnicatehnike.producttype.services.implementations;

import com.iis.prodavnicatehnike.producttype.models.ProductType;
import com.iis.prodavnicatehnike.producttype.repositories.ProductTypeRepository;
import com.iis.prodavnicatehnike.producttype.services.interfaces.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductTypeServiceImpl implements ProductTypeService {

    @Autowired
    private ProductTypeRepository productTypeRepository;

    @Override
    public List<ProductType> findAllProductTypes() {
        return productTypeRepository.findAll();
    }

    @Override
    public Optional<ProductType> findProductTypeById(Integer id) {
        return productTypeRepository.findById(id);
    }

    @Override
    public ProductType createProductType(ProductType productType) {
        return productTypeRepository.save(productType);
    }

    @Override
    public Optional<ProductType> updateProductType(ProductType newProductType, Integer id) {
        return productTypeRepository.findById(id).map(oldProductType -> {
            oldProductType.setName(newProductType.getName());
            return productTypeRepository.save(oldProductType);
        });
    }

    @Override
    public void deleteProductType(Integer id) {
        productTypeRepository.deleteById(id);
    }
}