package com.agilne.assemblyMicroservice.services.implementations;

import com.agilne.assemblyMicroservice.Dto.ProductDto;
import com.agilne.assemblyMicroservice.models.Product;
import com.agilne.assemblyMicroservice.models.ProductType;
import com.agilne.assemblyMicroservice.services.interfaces.ProductService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class ProductServiceImpl implements ProductService {
private String baseUrl="http://localhost:8087/products";
    @Override
    public Product GetProductById(Integer id) {
        RestTemplate productRest=new RestTemplate();
        ProductDto product=productRest.getForObject(baseUrl+"/"+id, ProductDto.class);
        Product mappedProduct=new Product();
        ProductType mappedType=new ProductType();
        mappedType.setName(product.type);
        mappedType.setId(product.id);
        mappedProduct.setProductType(mappedType);
        mappedProduct.setAvailable(product.available);
        mappedProduct.setName(product.name);
        mappedProduct.setId(product.id);
        return mappedProduct;
    }
}
