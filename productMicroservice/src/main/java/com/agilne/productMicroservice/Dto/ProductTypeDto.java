package com.agilne.productMicroservice.Dto;

public class ProductTypeDto {
    public Integer id;
    public String name;

    public ProductTypeDto(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
    public ProductTypeDto(){}
}
