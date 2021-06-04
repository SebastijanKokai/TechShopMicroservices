package com.agilne.productMicroservice.services.implementations;

import com.agilne.productMicroservice.Dto.ProductTypeDto;
import com.agilne.productMicroservice.models.ProductType;
import com.agilne.productMicroservice.services.interfaces.ProductTypeService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
//@Service
public class ProductTypeServiceImpl implements ProductTypeService {
    private String baseUrl="localhost:8082/product_type";
    @Override
    public ProductType GetProductTypeById(Integer id) {
        RestTemplate productRest=new RestTemplate();
        ProductTypeDto product=productRest.getForObject(baseUrl+"/"+id, ProductTypeDto.class);
        ProductType mappedProduct=new ProductType();
        return mappedProduct;
    }
}
