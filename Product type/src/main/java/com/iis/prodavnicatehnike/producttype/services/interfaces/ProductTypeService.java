package com.iis.prodavnicatehnike.producttype.services.interfaces;

import com.iis.prodavnicatehnike.producttype.dtos.CreateProductTypeDTO;
import com.iis.prodavnicatehnike.producttype.dtos.ProductTypeDTO;

import java.util.List;
import java.util.Optional;

public interface ProductTypeService {
        List<ProductTypeDTO> findAllProductTypes();
        Optional<ProductTypeDTO> findProductTypeById(Integer id);
        ProductTypeDTO createProductType(CreateProductTypeDTO productType);
        Optional<ProductTypeDTO> updateProductType(CreateProductTypeDTO productType, Integer id);
        void deleteProductType(Integer id);
}
