package com.agilne.assemblyMicroservice.repositories;
import com.agilne.assemblyMicroservice.models.Assembly;
import com.agilne.assemblyMicroservice.models.AssemblyId;
import org.springframework.data.jpa.repository.JpaRepository;
public interface AssemblyRepository extends JpaRepository<Assembly, AssemblyId> {

}
