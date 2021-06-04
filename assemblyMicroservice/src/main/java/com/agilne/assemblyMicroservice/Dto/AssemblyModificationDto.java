package com.agilne.assemblyMicroservice.Dto;

public class AssemblyModificationDto {
    public Integer assemblyId;
    public Integer partId;
    public Integer quantity;

    public AssemblyModificationDto(Integer assemblyId, Integer partId, Integer quantity) {
        this.assemblyId = assemblyId;
        this.partId = partId;
        this.quantity = quantity;
    }
}
