package com.prodavnicatehnike.deliverer.services.implementations;

import com.prodavnicatehnike.deliverer.dtos.CreateDelivererDTO;
import com.prodavnicatehnike.deliverer.dtos.GetDelivererDTO;
import com.prodavnicatehnike.deliverer.models.Deliverer;
import com.prodavnicatehnike.deliverer.repositories.DelivererRepository;
import com.prodavnicatehnike.deliverer.services.interfaces.DelivererService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DelivererServiceImpl implements DelivererService {

    @Autowired
    private DelivererRepository delivererRepository;

    @Override
    public List<GetDelivererDTO> findAllDeliverers() {
        List<Deliverer> allDeliverers = delivererRepository.findAll();
        List<GetDelivererDTO> mappedDeliverers = new ArrayList<>() ;
        for (Deliverer s : allDeliverers) {
            mappedDeliverers.add(new GetDelivererDTO(s.getId(),s.getCompanyName(),s.getContact(),s.getAddress()));
        }
        return mappedDeliverers;
    }

    @Override
    public GetDelivererDTO findDelivererById(Integer id) {

        if(delivererRepository.findById(id).isPresent()) {
            Deliverer deliverer = delivererRepository.findById(id).get();
            String companyName = deliverer.getCompanyName();
            String  contact = deliverer.getContact();
            String address = deliverer.getAddress();
            return new GetDelivererDTO(id, companyName, contact, address);
        }
        return null;
    }

    @Override
    public GetDelivererDTO createDeliverer(CreateDelivererDTO deliverer) {
        Deliverer newDeliverer = new Deliverer();
        newDeliverer.setCompanyName(deliverer.companyName);
        newDeliverer.setContact(deliverer.contact);
        newDeliverer.setAddress(deliverer.address);
        newDeliverer = delivererRepository.save(newDeliverer);

        GetDelivererDTO mappedDeliverer=new GetDelivererDTO(newDeliverer.getId(),
                newDeliverer.getCompanyName(),newDeliverer.getContact(),
                newDeliverer.getAddress());

        return mappedDeliverer;
    }

    @Override
    public GetDelivererDTO updateDeliverer(CreateDelivererDTO deliverer, Integer id) {
        if(delivererRepository.findById(id).isPresent()) {
            Deliverer updatedDeliverer = delivererRepository.findById(id).map(oldDeliverer -> {
                oldDeliverer.setCompanyName(deliverer.companyName);
                oldDeliverer.setContact(deliverer.contact);
                oldDeliverer.setAddress(deliverer.address);
                return delivererRepository.save(oldDeliverer);
            }).get();

            GetDelivererDTO mappedDeliverer = new GetDelivererDTO(updatedDeliverer.getId(),
                    updatedDeliverer.getCompanyName(), updatedDeliverer.getContact(),
                    updatedDeliverer.getAddress());
            return mappedDeliverer;
        }
        return null;
    }

    @Override
    public void deleteDeliverer(Integer id) {
        if(delivererRepository.findById(id).isPresent()) {
            delivererRepository.deleteById(id);
        }
    }
}
