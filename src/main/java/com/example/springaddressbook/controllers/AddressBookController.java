package com.example.springaddressbook.controllers;

import com.example.springaddressbook.DTO.AddressBookDTO;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/addressbookservice")
public class AddressBookController {

    /** UC 2: Rest Controller to demonstrate various HTTP methods*/

    @RequestMapping(value ={"","/","/get"})
    public ResponseEntity<String> getAddressBookData(){
        return new ResponseEntity<String>("Get call success", HttpStatus.OK);
    }

    @PostMapping(value ={"/create"})
    public ResponseEntity<String> addAddressBookData(@RequestBody AddressBookDTO addressBookDTO){
        return new ResponseEntity<String>("Created Address Book data for: "+ addressBookDTO, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateAddressBookData(@RequestBody AddressBookDTO addressBookDTO){
        return new ResponseEntity<String>("Updated Address Book data for: "+addressBookDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{name}")
    public ResponseEntity<String> deleteAddressBookData(@PathVariable("name") String name){
        return new ResponseEntity<>("Deleted Address Book Data for: " + name, HttpStatus.OK);
    }
}
