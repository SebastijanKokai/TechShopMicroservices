package com.agilne.productMicroservice.Dto;

public class ProductDto {
    public Integer id;
    public String name;
    public Integer typeId;
    public String type;
    public Integer available;

    public ProductDto(Integer id, String name, Integer typeId, String type, Integer available) {
        this.id = id;
        this.name = name;
        this.typeId = typeId;
        this.type = type;
        this.available = available;
    }
}
