package com.example.trelloweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class TrelloWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(TrelloWebApplication.class, args);
    }

}
