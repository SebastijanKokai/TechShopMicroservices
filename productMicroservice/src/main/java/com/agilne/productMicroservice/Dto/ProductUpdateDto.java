package com.agilne.productMicroservice.Dto;

public class ProductUpdateDto {
    public Integer id;
    public String name;
    public Integer typeId;
    public Integer available;

    public ProductUpdateDto(Integer id, String name, Integer typeId, Integer available) {
        this.id = id;
        this.name = name;
        this.typeId = typeId;
        this.available = available;
    }
    public ProductUpdateDto(){}
}
