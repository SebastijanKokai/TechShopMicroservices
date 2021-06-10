package com.agilne.prodavnica_tehnike.utils;

import com.agilne.prodavnica_tehnike.models.Deliverer;
import org.springframework.web.client.RestTemplate;

public class DelivererService {
    private final RestTemplate restTemplate = new RestTemplate();
    private final String delivererURL = "http://localhost:8082/deliverers";

    public Deliverer getDelivererById(Integer delivererId) {
        return restTemplate.getForObject(delivererURL + "/" + delivererId, Deliverer.class);
    }
}
