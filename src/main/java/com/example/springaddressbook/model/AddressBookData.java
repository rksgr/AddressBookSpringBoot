package com.example.springaddressbook.model;

import com.example.springaddressbook.DTO.AddressBookDTO;

public class AddressBookData {
    private String name;
    private String city;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public AddressBookData(String name, String city){
        this.name = name;
        this.city = city;
    }
    public AddressBookData(AddressBookDTO addressBookDTO){
        this.name = addressBookDTO.getName();
        this.city = addressBookDTO.getCity();
    }
}
