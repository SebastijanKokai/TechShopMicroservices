package com.iis.prodavnicatehnike.producttype.services.implementations;

import com.iis.prodavnicatehnike.producttype.dtos.CreateProductTypeDTO;
import com.iis.prodavnicatehnike.producttype.dtos.ProductTypeDTO;
import com.iis.prodavnicatehnike.producttype.models.ProductType;
import com.iis.prodavnicatehnike.producttype.repositories.ProductTypeRepository;
import com.iis.prodavnicatehnike.producttype.services.interfaces.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductTypeServiceImpl implements ProductTypeService {

    @Autowired
    private ProductTypeRepository productTypeRepository;

    @Override
    public List<ProductTypeDTO> findAllProductTypes() {
        List<ProductType> productTypeEntities = productTypeRepository.findAll();
        List<ProductTypeDTO> productTypeDTOS = new ArrayList<>();
        for (ProductType productType : productTypeEntities) {
            productTypeDTOS.add(new ProductTypeDTO(productType.getId(), productType.getName()));
        }
        return productTypeDTOS;
    }

    @Override
    public Optional<ProductTypeDTO> findProductTypeById(Integer id) {
        Optional<ProductType> productTypeEntity = productTypeRepository.findById(id);
        return productTypeEntity.map(productType -> new ProductTypeDTO(productType.getId(), productType.getName()));
    }

    @Override
    public ProductTypeDTO createProductType(CreateProductTypeDTO productType) {
        ProductType productTypeEntity = new ProductType();
        productTypeEntity.setName(productType.getName());
        ProductType newEntity = productTypeRepository.save(productTypeEntity);
        return new ProductTypeDTO(newEntity.getId(), newEntity.getName());
    }

    @Override
    public Optional<ProductTypeDTO> updateProductType(CreateProductTypeDTO newProductType, Integer id) {
        return productTypeRepository.findById(id).map(oldProductType -> {
            oldProductType.setName(newProductType.getName());
            ProductType updatedProductType = productTypeRepository.save(oldProductType);
            return new ProductTypeDTO(updatedProductType.getId(), updatedProductType.getName());
        });
    }

    @Override
    public void deleteProductType(Integer id) {
        productTypeRepository.deleteById(id);
    }
}