package com.example.springaddressbook.model;

import com.example.springaddressbook.DTO.AddressBookDTO;
import lombok.Data;

public @Data class AddressBookData {

    private String name;
    private String address;
    private String city;
    private String state;
    private int zip;
    private float phoneNo;
    private String emailId;

    public AddressBookData(){}

    public AddressBookData(AddressBookDTO addressBookDTO){
        this.name = addressBookDTO.getName();
        this.address = addressBookDTO.getAddress();
        this.city = addressBookDTO.getCity();
        this.state = addressBookDTO.getState();
        this.zip = addressBookDTO.getZip();
        this.phoneNo = addressBookDTO.getPhoneNo();
        this.emailId = addressBookDTO.getEmailId();
    }
}
