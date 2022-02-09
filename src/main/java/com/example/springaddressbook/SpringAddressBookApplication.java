package com.example.springaddressbook;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class SpringAddressBookApplication {

    /**UC 2: Use Lombok library for logging */
    public static void main(String[] args) {
        SpringApplication.run(SpringAddressBookApplication.class, args);
        log.info("Address Book App started.");
    }
}
