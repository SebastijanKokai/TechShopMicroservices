package com.agilne.assemblyMicroservice.services.interfaces;

import com.agilne.assemblyMicroservice.Dto.AssemblyDto;
import com.agilne.assemblyMicroservice.Dto.AssemblyModificationDto;
import com.agilne.assemblyMicroservice.models.Assembly;

import java.util.List;
import java.util.Optional;

public interface AssemblyService {
    public List<AssemblyDto> getAllAssemblies();
    public AssemblyDto getAssemblyById(Integer assemblyId,Integer partId );
    public AssemblyDto insert(AssemblyModificationDto assembly);
    public AssemblyDto update(AssemblyModificationDto assembly, Integer assemblyId,Integer partId);
    public void delete(Integer assembly,Integer part);
}
