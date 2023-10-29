package com.example.freelance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class FreelanceApplication {

    public static void main(String[] args) {
        SpringApplication.run(FreelanceApplication.class, args);
    }

}
