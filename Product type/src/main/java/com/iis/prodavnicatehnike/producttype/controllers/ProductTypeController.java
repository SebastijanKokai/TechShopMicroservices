package com.iis.prodavnicatehnike.producttype.controllers;

import com.iis.prodavnicatehnike.producttype.models.ProductType;
import com.iis.prodavnicatehnike.producttype.services.interfaces.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/product-types")
public class ProductTypeController {

    @Autowired
    private ProductTypeService productTypeService;

    @GetMapping()
    public ResponseEntity<List<ProductType>> getAllProductTypes() {

        return ResponseEntity.ok(productTypeService.findAllProductTypes());
    }

    @GetMapping(path="{id}")
    public ResponseEntity<Optional<ProductType>> getProductTypeById(@PathVariable("id") Integer id)
    {
        return  ResponseEntity.ok(productTypeService.findProductTypeById(id));
    }

    @PostMapping()
    public ResponseEntity<ProductType> insertProductType(@RequestBody ProductType productType)
    {
        return ResponseEntity.ok(productTypeService.createProductType(productType));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Optional<ProductType>> updateProductType(@RequestBody ProductType newProductType, @PathVariable("id") Integer id)
    {
        Optional<ProductType> productType = productTypeService.updateProductType(newProductType, id);
        if (productType.isPresent()) {
            return ResponseEntity.ok(productType);
        } else {
            return ResponseEntity.badRequest().body(productType);
        }
    }
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteProductType(@PathVariable("id") Integer id)
    {
        productTypeService.deleteProductType(id);
        return ResponseEntity.noContent().build();
    }
}

