package com.agilne.assemblyMicroservice.services.implementations;

import com.agilne.assemblyMicroservice.Dto.AssemblyDto;
import com.agilne.assemblyMicroservice.Dto.AssemblyModificationDto;
import com.agilne.assemblyMicroservice.models.Assembly;
import com.agilne.assemblyMicroservice.models.AssemblyId;
import com.agilne.assemblyMicroservice.repositories.AssemblyRepository;
import com.agilne.assemblyMicroservice.services.interfaces.AssemblyService;
import com.agilne.assemblyMicroservice.services.interfaces.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AssemblyServiceImpl implements AssemblyService {
    @Autowired
    private AssemblyRepository assemblyRepository;
    @Autowired
    private ProductService productService;

    public ProductService getProductService() {
        return productService;
    }

    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    public AssemblyRepository getAssemblyRepository() {
        return assemblyRepository;
    }

    public void setAssemblyRepository(AssemblyRepository assemblyRepository) {
        this.assemblyRepository = assemblyRepository;
    }
    @Override
    public List<AssemblyDto> getAllAssemblies()
    {
        List<Assembly> allAssemblies=assemblyRepository.findAll();
        List<AssemblyDto> mappedAssemblies=new ArrayList<>() ;
        for (Assembly s :
                allAssemblies) {
            s.setAssembly(productService.GetProductById(s.getAssemblyId()));
            s.setPart(productService.GetProductById(s.getPartId()));
            mappedAssemblies.add(new AssemblyDto(s.getPartId(),s.getPart().getName(),s.getPart().getProductType().getName(),s.getAssemblyId(),s.getAssembly().getName(),s.getAssembly().getProductType().getName(),s.getQuantity()));
        }
        return mappedAssemblies;
    }

    @Override
    public AssemblyDto getAssemblyById(Integer assembly,Integer part) {
        Assembly foundAssembly=assemblyRepository.findById(new AssemblyId(assembly,part)).get();
        foundAssembly.setAssembly(productService.GetProductById(foundAssembly.getAssemblyId()));
        foundAssembly.setPart(productService.GetProductById(foundAssembly.getPartId()));
        AssemblyDto mappedAssembly=new AssemblyDto(foundAssembly.getPartId(),foundAssembly.getPart().getName(),foundAssembly.getPart().getProductType().getName(),foundAssembly.getAssemblyId(),foundAssembly.getAssembly().getName(),foundAssembly.getAssembly().getProductType().getName(),foundAssembly.getQuantity());
        return mappedAssembly;
    }

    @Override
    public AssemblyDto insert(AssemblyModificationDto assembly) {
        Assembly newAssembly=new Assembly();
        newAssembly.setPartId(assembly.partId);
        newAssembly.setQuantity(assembly.quantity);
        newAssembly.setAssemblyId(assembly.assemblyId);
        newAssembly=assemblyRepository.save(newAssembly);
        newAssembly.setAssembly(productService.GetProductById(newAssembly.getAssemblyId()));
        newAssembly.setPart(productService.GetProductById(newAssembly.getPartId()));
        AssemblyDto mappedAssembly=new AssemblyDto(newAssembly.getPartId(),newAssembly.getPart().getName(),newAssembly.getPart().getProductType().getName(),newAssembly.getAssemblyId(),newAssembly.getAssembly().getName(),newAssembly.getAssembly().getProductType().getName(),newAssembly.getQuantity());
        return mappedAssembly;
    }

    @Override
    public AssemblyDto update(AssemblyModificationDto assembly, Integer assemblyId,Integer partId) {
        Assembly updatedAssembly=assemblyRepository.findById(new AssemblyId(assemblyId,partId)).map(oldAssembly ->{
            oldAssembly.setQuantity(assembly.quantity);
            return assemblyRepository.save(oldAssembly);
        } ).get();
        updatedAssembly.setAssembly(productService.GetProductById(updatedAssembly.getAssemblyId()));
        updatedAssembly.setPart(productService.GetProductById(updatedAssembly.getPartId()));
        AssemblyDto mappedAssembly=new AssemblyDto(updatedAssembly.getPartId(),updatedAssembly.getPart().getName(),updatedAssembly.getPart().getProductType().getName(),updatedAssembly.getAssemblyId(),updatedAssembly.getAssembly().getName(),updatedAssembly.getAssembly().getProductType().getName(),updatedAssembly.getQuantity());
        return  mappedAssembly;
    }

    @Override
    public void delete(Integer assembly,Integer part) {
        assemblyRepository.deleteById(new AssemblyId(assembly,part));
    }
}
