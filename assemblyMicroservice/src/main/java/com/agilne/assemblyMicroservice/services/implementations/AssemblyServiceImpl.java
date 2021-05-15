package com.agilne.assemblyMicroservice.services.implementations;

import com.agilne.assemblyMicroservice.models.Assembly;
import com.agilne.assemblyMicroservice.models.AssemblyId;
import com.agilne.assemblyMicroservice.repositories.AssemblyRepository;
import com.agilne.assemblyMicroservice.services.interfaces.AssemblyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssemblyServiceImpl implements AssemblyService {
    @Autowired
    private AssemblyRepository assemblyRepository;

    public AssemblyRepository getAssemblyRepository() {
        return assemblyRepository;
    }

    public void setAssemblyRepository(AssemblyRepository assemblyRepository) {
        this.assemblyRepository = assemblyRepository;
    }
    @Override
    public List<Assembly> getAllAssemblies()
    {
        return assemblyRepository.findAll();
    }

    @Override
    public Optional<Assembly> getAssemblyById(Integer assembly,Integer part) {
        return assemblyRepository.findById(new AssemblyId(assembly,part));
    }

    @Override
    public Assembly insert(Assembly assembly) {
        return assemblyRepository.save(assembly);
    }

    @Override
    public Optional<Assembly> update(Assembly assembly, Integer assemblyId,Integer partId) {
        return assemblyRepository.findById(new AssemblyId(assemblyId,partId)).map(oldAssembly ->{
            oldAssembly.setQuantity(assembly.getQuantity());
            return assemblyRepository.save(oldAssembly);
        } );
    }

    @Override
    public void delete(Integer assembly,Integer part) {
        assemblyRepository.deleteById(new AssemblyId(assembly,part));
    }
}
