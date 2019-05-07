package com.simple.crud15;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@EnableJpaRepositories("com.simple.crud15.repository")
public class CrudeverisApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrudeverisApplication.class, args);
    }

}
