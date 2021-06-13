package com.iis.prodavnicatehnike.employees.dtos;

public class EmployeeDTO {
    private Integer id;
    private String name;
    private String lastName;
    private String contact;

    public EmployeeDTO(Integer id, String name, String lastName, String contact) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.contact = contact;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
