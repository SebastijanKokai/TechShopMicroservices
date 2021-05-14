package com.iis.prodavnicatehnike.controllers;

import com.iis.prodavnicatehnike.models.ProductType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.iis.prodavnicatehnike.repositories.ProductTypeRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/product-types")
public class ProductTypeController {

    @Autowired
    private ProductTypeRepository productTypeRepository;

    @GetMapping()
    public ResponseEntity<List<ProductType>> getAllProductTypes() {

        return ResponseEntity.ok(productTypeRepository.findAll());
    }

    @GetMapping(path="{id}")
    public ResponseEntity<Optional<ProductType>> getProductTypeById(@PathVariable("id") Integer id)
    {
        return  ResponseEntity.ok(productTypeRepository.findById(id));
    }

    @PostMapping()
    public ResponseEntity<ProductType> insertProductType(@RequestBody ProductType productType)
    {
        return ResponseEntity.ok(productTypeRepository.save(productType));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Optional<ProductType>> updateProductType(@RequestBody ProductType newProductType, @PathVariable("id") Integer id)
    {
        Optional<ProductType> productType = productTypeRepository.findById(id).map(oldProductType -> {
            oldProductType.setName(newProductType.getName());
            return productTypeRepository.save(oldProductType);
        });
        if (productType.isPresent()) {
            return ResponseEntity.ok(productType);
        } else {
            return ResponseEntity.badRequest().body(productType);
        }
    }
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteProductType(@PathVariable("id") Integer id)
    {
        productTypeRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

