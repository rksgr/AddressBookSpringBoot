package com.example.springaddressbook.service;

import com.example.springaddressbook.DTO.AddressBookDTO;
import com.example.springaddressbook.model.AddressBookData;
import com.sun.tools.jconsole.JConsoleContext;
import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.stereotype.Service;

import java.io.Console;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@Service
public class AddressBookService implements IAddressBookService{
    private List<AddressBookData> addressBookDataList = new ArrayList<>();

    public List<AddressBookData> getAddressBookData(){  return addressBookDataList; }

    public AddressBookData createAddressBookData(AddressBookDTO addressBookDTO){
        AddressBookData addressBookData = null;
        addressBookData = new AddressBookData(addressBookDTO);
        addressBookDataList.add(addressBookData);
        return addressBookData;
    }

    // Update the address book data
    public AddressBookData updateAddressBookData(AddressBookDTO addressBookDTO, String name) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        AddressBookData addressBookData = null;

        for (int i=0;i<addressBookDataList.size();i++){
            if (addressBookDataList.get(i).getName().equals(name)){
                System.out.println("inside for if");
                addressBookData = this.addressBookDataList.get(i);

                // Using BeanUtils to set the name and city fields
                PropertyUtils.setSimpleProperty(addressBookData,"name",addressBookDTO.name);
                PropertyUtils.setSimpleProperty(addressBookData,"city",addressBookDTO.city);
                addressBookDataList.set(i,addressBookData);
            }
        }
        return addressBookData;
    }

    // Delete the address book data
    public boolean deleteAddressBookData(String name){
        boolean personFound = false;
        for (int i=0;i<addressBookDataList.size();i++){
            if (addressBookDataList.get(i).getName().equals(name)){
                addressBookDataList.remove(i);
                personFound = true;
            }
        }
        return personFound;
    }
}
