package com.example.springaddressbook.DTO;

import lombok.Data;

/** UC 1: Use lombok library to auto generate getters and setters for the DTO */
public @Data class AddressBookDTO {
    public String name;
    public String city;

    public AddressBookDTO(String name, String city) {
        this.name = name;
        this.city = city;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
