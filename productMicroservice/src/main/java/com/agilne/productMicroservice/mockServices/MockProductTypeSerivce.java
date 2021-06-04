package com.agilne.productMicroservice.mockServices;

import com.agilne.productMicroservice.models.ProductType;
import com.agilne.productMicroservice.services.interfaces.ProductTypeService;
import org.springframework.stereotype.Service;

@Service
public class MockProductTypeSerivce implements ProductTypeService {
    @Override
    public ProductType GetProductTypeById(Integer id) {
        ProductType mockProductType=new ProductType();
        mockProductType.setName("Ja sam fake product type");
        mockProductType.setId(id);
        return mockProductType;
    }
}
