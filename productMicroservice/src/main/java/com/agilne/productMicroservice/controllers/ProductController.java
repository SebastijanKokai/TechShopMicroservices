package com.agilne.productMicroservice.controllers;

import com.agilne.productMicroservice.Dto.ProductCreationDto;
import com.agilne.productMicroservice.Dto.ProductDto;
import com.agilne.productMicroservice.Dto.ProductUpdateDto;
import com.agilne.productMicroservice.models.Product;
import com.agilne.productMicroservice.services.interfaces.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    public ProductService getProductService() {
        return productService;
    }

    public void setProductService(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping()
    public ResponseEntity<List<ProductDto>> getAllProducts()
    {
        return ResponseEntity.ok(productService.getAllProducts());
    }
    @GetMapping(path="{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable("id") Integer id)
    {
        return  ResponseEntity.ok(productService.getProductById(id));
    }
    @PostMapping()
    public ResponseEntity<ProductDto> insertProduct(@RequestBody ProductCreationDto product)
    {
        return ResponseEntity.ok(productService.insert(product));
    }
    @PutMapping(path = "/{id}")
    public ResponseEntity<ProductDto> updateProduct(@RequestBody ProductUpdateDto product, @PathVariable("id") Integer id)
    {
        return ResponseEntity.ok(productService.update(product,id));
    }
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") Integer id)
    {
        productService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
