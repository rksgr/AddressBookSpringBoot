package com.example.springaddressbook.controllers;

import com.example.springaddressbook.DTO.AddressBookDTO;
import com.example.springaddressbook.DTO.ResponseDTO;
import com.example.springaddressbook.model.AddressBookData;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import javax.validation.Valid;

@RestController
@RequestMapping("/addressbookservice")
public class AddressBookController {


    /** UC 2: Rest Controller to demonstrate various HTTP methods*/
    /**
     * Method: To get the details of ALL the persons from Address Book
     *                  Performs RETRIEVE operation
     *
     * @return A JSON Response containing address details of all the persons
     */
    @RequestMapping(value ={"","/","/get"})
    public ResponseEntity<ResponseDTO> getAddressBookData(){
        AddressBookDTO addressBookDTO = new AddressBookDTO("Arun","Ranchi");
        ResponseDTO respDTO = new ResponseDTO(" Fetched Address Book Data: ", addressBookDTO);
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
        ResponseDTO respDTO = new ResponseDTO("Created Address Book Data: ", addressBookDTO);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    /**
     * Method: To update the details of a person present in the Address Book based on name
     *                  Performs UPDATE operation
     *
     * @return A JSON Response containing address details of the person updated
     */
    @PutMapping("/update/{name}")
    public ResponseEntity<ResponseDTO> updateAddressBookData(@RequestBody AddressBookDTO addressBookDTO,
                                                             @PathVariable ("name") String name){
        ResponseDTO respDTO = new ResponseDTO(" Updated Address Book Data of: " +name, addressBookDTO);
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
        ResponseDTO respDTO = new ResponseDTO(" Deleted Address Book Data of: "+ name, name);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }
}
