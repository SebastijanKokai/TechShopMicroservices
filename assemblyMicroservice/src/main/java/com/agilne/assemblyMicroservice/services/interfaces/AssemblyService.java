package com.agilne.assemblyMicroservice.services.interfaces;

import com.agilne.assemblyMicroservice.models.Assembly;

import java.util.List;
import java.util.Optional;

public interface AssemblyService {
    public List<Assembly> getAllAssemblies();
    public Optional<Assembly> getAssemblyById(Integer assemblyId,Integer partId );
    public Assembly insert(Assembly assembly);
    public Optional<Assembly> update(Assembly assembly, Integer assemblyId,Integer partId);
    public void delete(Integer assembly,Integer part);
}
