package com.agilne.assemblyMicroservice.Dto;

public class AssemblyDto {
    public Integer partId;
    public String partName;
    public String partType;
    public Integer assemblyId;
    public String assemblyName;
    public String assemblyType;
    public Integer quantity;

    public AssemblyDto(Integer partId, String partName, String partType, Integer assemblyId, String assemblyName, String assemblyType, Integer quantity) {
        this.partId = partId;
        this.partName = partName;
        this.partType = partType;
        this.assemblyId = assemblyId;
        this.assemblyName = assemblyName;
        this.assemblyType = assemblyType;
        this.quantity = quantity;
    }
}
