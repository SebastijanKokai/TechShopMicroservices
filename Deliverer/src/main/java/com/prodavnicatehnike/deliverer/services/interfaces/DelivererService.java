package com.prodavnicatehnike.deliverer.services.interfaces;

import com.prodavnicatehnike.deliverer.dtos.CreateDelivererDTO;
import com.prodavnicatehnike.deliverer.dtos.GetDelivererDTO;
import com.prodavnicatehnike.deliverer.models.Deliverer;

import java.util.List;
import java.util.Optional;

public interface DelivererService {
    List<GetDelivererDTO> findAllDeliverers();
    GetDelivererDTO findDelivererById(Integer id);
    GetDelivererDTO createDeliverer(CreateDelivererDTO deliverer);
    GetDelivererDTO updateDeliverer(CreateDelivererDTO deliverer, Integer id);
    void deleteDeliverer(Integer id);
}
