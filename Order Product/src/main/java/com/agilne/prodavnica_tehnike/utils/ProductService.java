package com.agilne.prodavnica_tehnike.utils;

import com.agilne.prodavnica_tehnike.models.Product;
import org.springframework.web.client.RestTemplate;

public class ProductService {
    private final RestTemplate restTemplate = new RestTemplate();
    private final String productResourceURL = "http://localhost:8087/products";

    public Product getProductById(Integer productId) {
        return restTemplate.getForObject(productResourceURL + "/" + productId, Product.class);
    }
}
