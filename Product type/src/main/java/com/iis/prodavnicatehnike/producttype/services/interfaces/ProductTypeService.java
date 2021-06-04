package com.iis.prodavnicatehnike.producttype.services.interfaces;

import com.iis.prodavnicatehnike.producttype.models.ProductType;

import java.util.List;
import java.util.Optional;

public interface ProductTypeService {
        List<ProductType> findAllProductTypes();
        Optional<ProductType> findProductTypeById(Integer id);
        ProductType createProductType(ProductType productType);
        Optional<ProductType> updateProductType(ProductType productType, Integer id);
        void deleteProductType(Integer id);
}
