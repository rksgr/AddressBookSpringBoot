package com.example.springaddressbook;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@Slf4j
public class SpringAddressBookApplication {

    /**UC4 : Database setting as environment variable **/
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringAddressBookApplication.class, args);

        // Logging the environment from appropriate application property
        log.info("Address Book App started in {} environment",context.getEnvironment().getProperty("environment"));

        //Log the data source username
        log.info("Address book DB user is {}", context.getEnvironment().getProperty("spring.datasource.username"));
    }
}
