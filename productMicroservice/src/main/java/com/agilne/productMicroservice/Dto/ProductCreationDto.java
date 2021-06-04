package com.agilne.productMicroservice.Dto;

public class ProductCreationDto {
    public String name;
    public Integer typeId;
    public Integer available;

    public ProductCreationDto( String name, Integer typeId, Integer available) {
        this.name = name;
        this.typeId = typeId;
        this.available = available;
    }
}
