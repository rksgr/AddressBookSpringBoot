package com.example.springaddressbook.DTO;

public class AddressBookDTO {
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
