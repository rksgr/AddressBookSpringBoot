package com.example.springaddressbook.DTO;

import lombok.Data;
import lombok.ToString;

/** UC 1: Use lombok library to auto generate getters and setters and override toString() method for the DTO */
public @Data @ToString class AddressBookDTO {
    public String name;
    private String address;
    public String city;
    public String state;
    public int zip;
    private String emailId;
    private float phoneNo;

    public AddressBookDTO(String name,String address, String city, String state,int zip,float phoneNo, String emailId) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.emailId = emailId;
        this.phoneNo = phoneNo;
    }
}
