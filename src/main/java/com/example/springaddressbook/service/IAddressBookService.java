package com.example.springaddressbook.service;

import com.example.springaddressbook.DTO.AddressBookDTO;
import com.example.springaddressbook.model.AddressBookData;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface IAddressBookService{

    List<AddressBookData> getAddressBookData();

    List<AddressBookData> getAddressBookDataByCity(String city);

    List<AddressBookData> getAddressBookDataByState(String state);

    AddressBookData createAddressBookData(AddressBookDTO addressBookDTO);

    AddressBookData updateAddressBookData(AddressBookDTO addressBookDTO, String name) throws
            IllegalAccessException, NoSuchMethodException, InvocationTargetException;

    boolean deleteAddressBookData(String name);
}