package com.agilne.productMicroservice.controllers;

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
    public ResponseEntity<List<Product>> getAllProducts()
    {
        return ResponseEntity.ok(productService.getAllProducts());
    }
    @GetMapping(path="{id}")
    public ResponseEntity<Optional<Product>> getProductById(@PathVariable("id") Integer id)
    {
        return  ResponseEntity.ok(productService.getProductById(id));
    }
    @PostMapping()
    public ResponseEntity<Product> insertProduct(@RequestBody Product product)
    {
        return ResponseEntity.ok(productService.insert(product));
    }
    @PutMapping(path = "/{id}")
    public ResponseEntity<Optional<Product>> updateProduct(@RequestBody Product product, @PathVariable("id") Integer id)
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
