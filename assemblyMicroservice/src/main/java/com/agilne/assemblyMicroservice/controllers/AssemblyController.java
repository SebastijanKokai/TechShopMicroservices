package com.agilne.assemblyMicroservice.controllers;

import com.agilne.assemblyMicroservice.Dto.AssemblyDto;
import com.agilne.assemblyMicroservice.Dto.AssemblyModificationDto;
import com.agilne.assemblyMicroservice.models.Assembly;
import com.agilne.assemblyMicroservice.services.interfaces.AssemblyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@RestController
@RequestMapping(path = "/assemblies")
public class AssemblyController {

    @Autowired
    private AssemblyService assemblyService;

    public AssemblyService getAssemblyService() {
        return assemblyService;
    }

    public void setAssemblyService(AssemblyService assemblyService) {
        this.assemblyService = assemblyService;
    }

    @GetMapping()
    public ResponseEntity<List<AssemblyDto>> getAllAssemblies(){
        return ResponseEntity.ok(assemblyService.getAllAssemblies());
    }
    @GetMapping(path = "/{assembly}/{part}")
    public ResponseEntity<AssemblyDto> getAssemblyById(@PathVariable("assembly") Integer assembly,@PathVariable("part") Integer part)
    {
        return ResponseEntity.ok(assemblyService.getAssemblyById(assembly,part));
    }
    @PostMapping()
    public ResponseEntity<AssemblyDto> insertAssembly(@RequestBody AssemblyModificationDto assembly)
    {
        return ResponseEntity.ok(assemblyService.insert(assembly));
    }
    @PutMapping(path = "/{assemblyId}/{partId}")
    public ResponseEntity<AssemblyDto> updateAssembly(@RequestBody AssemblyModificationDto assembly, @PathVariable("assemblyId") Integer assemblyId, @PathVariable("partId") Integer partId)
    {
        return ResponseEntity.ok(assemblyService.update(assembly,assemblyId,partId));
    }
    @DeleteMapping(path = "/{assemblyId}/{partId}")
    public ResponseEntity deleteAssembly(@PathVariable("assemblyId") Integer assembly,@PathVariable("partId") Integer part)
    {
        assemblyService.delete(assembly,part)   ;
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
