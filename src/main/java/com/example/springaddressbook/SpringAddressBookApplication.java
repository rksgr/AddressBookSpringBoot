package com.example.springaddressbook;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@Slf4j
public class SpringAddressBookApplication {

    /**UC3 : Determine the logging levels, logging to console or file logging patterns etc based on this application running
     * in Development, staging or production **/
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringAddressBookApplication.class, args);

        // Logging the environment from appropriate application property
        log.info("Address Book App started in {} environment",context.getEnvironment().getProperty("environment"));
    }
}
