package com.example.springaddressbook.controllers;

import com.example.springaddressbook.DTO.AddressBookDTO;
import com.example.springaddressbook.DTO.ResponseDTO;
import com.example.springaddressbook.model.AddressBookData;
import com.example.springaddressbook.service.IAddressBookService;
import com.example.springaddressbook.service.AddressBookService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import java.util.List;

import javax.validation.Valid;

@RestController
@RequestMapping("/addressbookservice")
@Slf4j
public class AddressBookController {

    //Inject the services layer
    @Autowired
    private IAddressBookService iAddressBookService;

    /**
     * Method: To get the details of ALL the persons from Address Book
     *                  Performs RETRIEVE operation
     *
     * @return A JSON Response containing address details of all the persons
     */
    @RequestMapping(value ={"","/","/get"})
    public ResponseEntity<ResponseDTO> getAddressBookData(){
        List<AddressBookData> addressBookList = null;
        addressBookList = iAddressBookService.getAddressBookData();
        ResponseDTO respDTO = new ResponseDTO(" Fetched Address Book Data: ", addressBookList);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }
    /**
     * Method: To add the details of a new person to the Address Book
     *                  Performs CREATE operation
     *
     * @return A JSON Response containing address details of the person added
     */
    @PostMapping(value ={"/create"})
    public ResponseEntity<ResponseDTO> addAddressBookData(@Valid @RequestBody AddressBookDTO addressBookDTO){
        AddressBookData addressBookData = null;
        addressBookData = iAddressBookService.createAddressBookData(addressBookDTO);
        ResponseDTO respDTO = new ResponseDTO("Created Address Book Data: ", addressBookData);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    /**
     * Method: To update the details of a person present in the Address Book based on name
     *                  Performs UPDATE operation
     *
     * @return A JSON Response containing address details of the person updated
     */
    @SneakyThrows
    @PutMapping("/update/{name}")
    public ResponseEntity<ResponseDTO> updateAddressBookData(@RequestBody AddressBookDTO addressBookDTO,
                                                             @PathVariable ("name") String name){
        AddressBookData addressBookData = null;
        addressBookData = iAddressBookService.updateAddressBookData(addressBookDTO,name);
        ResponseDTO respDTO = new ResponseDTO(" Updated Address Book Data of: " +name, addressBookData);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    /**
     * Method: To delete the address details of a person present in the Address Book based on name
     *                  Performs DELETE operation
     *
     * @return A JSON Response containing address details of the person deleted from address book
     */
    @DeleteMapping("/delete/{name}")
    public ResponseEntity<ResponseDTO> deleteAddressBookData(@PathVariable("name") String name){
        boolean personFound = iAddressBookService.deleteAddressBookData(name);
        ResponseDTO respDTO = null;
        if(personFound){
            respDTO = new ResponseDTO(" Deleted Address Book Data of: "+ name, name);
        }else if(!personFound){
            respDTO = new ResponseDTO("Sorry! The person with name "+ name + " not found in the address book.", name);
        }
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }
}



